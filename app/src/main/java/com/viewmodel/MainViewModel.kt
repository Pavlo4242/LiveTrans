// app/src/main/java/com/bwctrans/viewmodel/MainViewModel.kt
package com.bwctrans.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bwctrans.R
import com.bwctrans.audio.AudioHandler
import com.bwctrans.audio.AudioPlayer
import com.bwctrans.data.*
import com.bwctrans.network.WebSocketClient
import com.google.gson.Gson
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(private val application: Application) : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
        private const val MAX_RECONNECT_ATTEMPTS = 5
    }

    // --- STATE FLOWS for UI State & Events ---
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<ViewEvent>()
    val events: SharedFlow<ViewEvent> = _events.asSharedFlow()

    sealed class ViewEvent {
        data class ShowToast(val message: String) : ViewEvent()
    }

    // --- PRIVATE PROPERTIES ---
    private var webSocketClient: WebSocketClient? = null
    private lateinit var audioHandler: AudioHandler
    private lateinit var audioPlayer: AudioPlayer
    private val gson = Gson()
    private var reconnectJob: Job? = null
    private var reconnectAttempts = 0

    // --- Buffers and state trackers ---
    private val userInputBuffer = StringBuilder()
    private val modelTranslationBuffer = StringBuilder()
    private var lastSpeakerIsUser: Boolean? = null
    private var sessionHandle: String? = null
    private var isServerReady = false

    // --- Configuration ---
    private val prefs = application.getSharedPreferences("BwctransPrefs", Context.MODE_PRIVATE)
    private val models = listOf("gemini-2.5-flash-preview-native-audio-dialog", "gemini-2.0-flash-live-001", "gemini-2.5-flash-live-preview")
    private lateinit var apiVersions: List<ApiVersion>
    private lateinit var apiKeys: List<ApiKeyInfo>
    private var selectedModel: String = ""
    private var selectedApiVersion: ApiVersion? = null
    private var selectedApiKey: ApiKeyInfo? = null

	sealed class ViewEvent {
        data class ShowToast(val message: String) : ViewEvent()
        data class ShareFile(val fileUri: android.net.Uri, val mimeType: String) : ViewEvent()
    }

    init {
        Log.d(TAG, "ViewModel initialized")
        audioPlayer = AudioPlayer()
        loadAllResources()
        updateToolbarText()
        // ViewModel is created after permission is granted, so we can init audio handler
        onPermissionResult(true)
    }

    // --- PUBLIC EVENT HANDLERS (called from View) ---

    fun onMicButtonClicked() {
        Log.d(TAG, "Mic button clicked.")
        if (!_uiState.value.isSessionActive) {
            connect()
            return
        }
        if (!isServerReady) {
            Log.w(TAG, "Server not ready, ignoring mic click.")
            return
        }
        val newListeningState = !_uiState.value.isListening
        if (newListeningState) {
            startAudio()
        } else {
            stopAudio()
        }
    }
	
	fun onClearLog() {
        _uiState.update { it.copy(debugLog = "") }
    }
	
	
	fun onShareLog() {
        viewModelScope.launch {
            val file = webSocketClient?.getLogFile()
            if (file != null && file.exists()) {
                val fileUri = androidx.core.content.FileProvider.getUriForFile(
                    application,
                    "${application.packageName}.provider",
                    file
                )
                _events.emit(ViewEvent.ShareFile(fileUri, "text/plain"))
            } else {
                _events.emit(ViewEvent.ShowToast("Log file not found or session not started."))
            }
        }
    }
	

    fun onConnectDisconnectClicked() {
        if (_uiState.value.isSessionActive) {
            Log.d(TAG, "Disconnect button clicked.")
            teardownSession(reconnect = false)
        } else {
            Log.d(TAG, "Connect button clicked.")
            connect()
        }
    }

    fun onForceConnect() {
        Log.i(TAG, "onForceConnect: Forcing reconnection.")
        viewModelScope.launch { _events.emit(ViewEvent.ShowToast("Forcing reconnection...")) }
        teardownSession(reconnect = false)
        viewModelScope.launch {
            delay(500)
            connect()
        }
    }

    fun onSettingsSaved() {
        Log.d(TAG, "Settings saved, reloading.")
        loadAllResources()
        updateToolbarText()
        if (_uiState.value.isSessionActive) {
            viewModelScope.launch {
                _events.emit(ViewEvent.ShowToast("Dev settings saved. Reconnect to apply."))
            }
        }
    }

    fun onPermissionResult(isGranted: Boolean) {
        if (isGranted) {
            Log.i(TAG, "Audio permission is granted. Initializing components.")
            if (!::audioHandler.isInitialized) {
                audioHandler = AudioHandler(application) { audioData ->
                    webSocketClient?.sendAudio(audioData)
                }
            }
            _uiState.update { it.copy(isMicButtonEnabled = true) }
        } else {
            Log.e(TAG, "Audio permission denied.")
            _uiState.update { it.copy(isMicButtonEnabled = false) }
            viewModelScope.launch { _events.emit(ViewEvent.ShowToast("Microphone permission is required to use this app.")) }
        }
    }


    // --- CORE LOGIC (moved from MainActivity) ---

    private fun connect() {
        if (_uiState.value.isSessionActive) {
            Log.w(TAG, "connect: Already connected or connecting.")
            return
        }
        reconnectJob?.cancel()
        reconnectAttempts = 0
        Log.i(TAG, "connect: Attempting to establish WebSocket connection.")
        updateStatus("Connecting...")
        prepareNewClient()
        webSocketClient?.connect()
    }

    private fun teardownSession(reconnect: Boolean = false) {
        if (!_uiState.value.isSessionActive && !reconnect) return
        Log.w(TAG, "teardownSession: Tearing down session. Reconnect: $reconnect")

        if (::audioHandler.isInitialized) audioHandler.stopRecording()
        webSocketClient?.disconnect()
        webSocketClient = null

        _uiState.update { it.copy(isListening = false, isSessionActive = false) }
        isServerReady = false

        if (!reconnect) {
            updateStatus("Disconnected")
        } else {
            scheduleReconnect()
        }
    }

    private fun scheduleReconnect() {
        reconnectJob?.cancel()
        if (reconnectAttempts >= MAX_RECONNECT_ATTEMPTS) {
            Log.e(TAG, "Max reconnect attempts reached. Will not reconnect.")
            updateStatus("Error", "Could not establish connection. Please try again later.")
            reconnectAttempts = 0
            return
        }

        reconnectAttempts++
        val delayMillis = (1000 * Math.pow(2.0, reconnectAttempts.toDouble())).toLong()
        Log.i(TAG, "Attempting to reconnect in ${delayMillis / 1000} seconds. (Attempt $reconnectAttempts)")
        updateStatus("Connection lost. Reconnecting in ${delayMillis / 1000}s...")

        reconnectJob = viewModelScope.launch {
            delay(delayMillis)
            connect()
        }
    }

    private fun startAudio() {
        if (!::audioHandler.isInitialized) {
            Log.e(TAG, "startAudio called but audioHandler not initialized.")
            return
        }
        Log.i(TAG, "startAudio: Starting audio recording.")
        audioHandler.startRecording()
        _uiState.update { it.copy(isListening = true) }
        updateStatus("Listening...")
    }

    private fun stopAudio() {
        if (::audioHandler.isInitialized) {
            Log.i(TAG, "stopAudio: Stopping audio recording.")
            audioHandler.stopRecording()
        }
        _uiState.update { it.copy(isListening = false) }
        updateStatus("Ready to listen")
    }

    // --- DATA & PREFERENCE MANAGEMENT ---

    private fun loadAllResources() {
        loadApiVersionsFromResources()
        loadApiKeysFromResources()
        loadPreferences()
        _uiState.update { it.copy(showDebugOverlay = prefs.getBoolean("show_debug_overlay", false)) }
    }

    private fun loadPreferences() {
        selectedModel = prefs.getString("selected_model", models.firstOrNull() ?: "") ?: ""
        sessionHandle = prefs.getString("session_handle", null)
        selectedApiVersion = apiVersions.firstOrNull { it.value == prefs.getString("api_version", null) } ?: apiVersions.firstOrNull()
        selectedApiKey = apiKeys.firstOrNull { it.value == prefs.getString("api_key", null) } ?: apiKeys.firstOrNull()
        Log.d(TAG, "loadPreferences: Loaded model '$selectedModel', version '${selectedApiVersion?.value}', key '${selectedApiKey?.displayName}'")
    }

    private fun loadApiVersionsFromResources() {
        val raw = application.resources.getStringArray(R.array.api_versions)
        apiVersions = raw.map {
            val parts = it.split("|", limit = 2)
            if (parts.size == 2) ApiVersion(parts[0].trim(), parts[1].trim())
            else ApiVersion(it.trim(), it.trim())
        }
    }

    private fun loadApiKeysFromResources() {
        val raw = application.resources.getStringArray(R.array.api_keys)
        apiKeys = raw.mapNotNull {
            val parts = it.split(":", limit = 2)
            if (parts.size == 2) ApiKeyInfo(parts[0].trim(), parts[1].trim()) else null
        }
    }

    private fun getVadSensitivity(): Int = prefs.getInt("vad_sensitivity_ms", 800)

    // --- WEBSOCKET & MESSAGE PROCESSING ---

    private fun prepareNewClient() {
        webSocketClient?.disconnect()
        loadPreferences() // Ensure we have the latest settings

       webSocketClient = WebSocketClient(
            context = application,
            host = prefs.getString("api_host", "generativelanguage.googleapis.com")!!, // Use saved host
            modelName = selectedModel,
            vadSilenceMs = getVadSensitivity(),
            apiVersion = selectedApiVersion?.value ?: "v1beta",
            apiKey = selectedApiKey?.value ?: "",
            sessionHandle = sessionHandle,
            onOpen = { viewModelScope.launch { onWebSocketOpen() } },
            onMessage = { text -> viewModelScope.launch { processServerMessage(text) } },
            onClosing = { code, reason -> viewModelScope.launch { onWebSocketClosing(code, reason) } },
            onFailure = { t, response -> viewModelScope.launch { onWebSocketFailure(t, response) } },
            onSetupComplete = { viewModelScope.launch { onWebSocketSetupComplete() } },
            onLogToOverlay = { message -> viewModelScope.launch { logToOverlay(message) } }
        )
        Log.i(TAG, "New WebSocketClient prepared for host: ${prefs.getString("api_host", "")}")
    }

    private fun onWebSocketOpen() {
        Log.i(TAG, "WebSocket onOpen callback received.")
        reconnectAttempts = 0
        reconnectJob?.cancel()
        _uiState.update { it.copy(isSessionActive = true) }
        updateStatus("Connected, configuring server...")
    }

    private fun onWebSocketSetupComplete() {
        Log.i(TAG, "WebSocket onSetupComplete callback received.")
        isServerReady = true
        updateStatus("Ready to listen")
    }

    private fun onWebSocketClosing(code: Int, reason: String) {
        Log.w(TAG, "WebSocket onClosing: Code=$code, Reason=$reason")
        val displayReason = if (code != 1000) " (Reason: $reason)" else ""
        viewModelScope.launch { _events.emit(ViewEvent.ShowToast("Connection closed: $code$displayReason")) }
        teardownSession(reconnect = true)
    }

    private fun onWebSocketFailure(t: Throwable, response: Response?) {
        Log.e(TAG, "WebSocket onFailure.", t)
        var errorMessage = "Connection error: ${t.message}"
        response?.let {
            errorMessage += "\n(Code: ${it.code})"
            if (it.code == 404) {
                errorMessage = "Error: The server endpoint was not found (404). Please check the API version and key."
            }
        }
        updateStatus("Error", errorMessage)
        teardownSession(reconnect = true)
    }

    private fun processServerMessage(text: String) {
        Log.v(TAG, "Received raw message: ${text.take(500)}...")
        try {
            val response = gson.fromJson(text, ServerResponse::class.java)

            response.sessionResumptionUpdate?.let {
                if (it.resumable == true && it.newHandle != null) {
                    sessionHandle = it.newHandle
                    prefs.edit().putString("session_handle", sessionHandle).apply()
                    Log.i(TAG, "Session handle updated and saved: $sessionHandle")
                    logToOverlay("[DEBUG] Session handle updated.")
                }
            }
            response.goAway?.timeLeft?.let {
                Log.w(TAG, "Received GO_AWAY message. Time left: $it. Will reconnect.")
                viewModelScope.launch { _events.emit(ViewEvent.ShowToast("Connection closing in $it. Will reconnect.")) }
            }

            val serverContent = response.serverContent

            // Input Transcription (user)
            val inputText = response.inputTranscription?.text ?: serverContent?.inputTranscription?.text
            if (inputText != null) {
                if (lastSpeakerIsUser == false) modelTranslationBuffer.clear()
                lastSpeakerIsUser = true
                userInputBuffer.append(inputText)
                addOrUpdateTranslation(userInputBuffer.toString().trim(), true)
            }

            // Output Transcription (model)
            val outputText = response.outputTranscription?.text ?: serverContent?.outputTranscription?.text
            if (outputText != null) {
                if (lastSpeakerIsUser == true) userInputBuffer.clear()
                lastSpeakerIsUser = false
                modelTranslationBuffer.append(outputText)
                addOrUpdateTranslation(modelTranslationBuffer.toString().trim(), false)
            }

            // Audio Output
            serverContent?.modelTurn?.parts?.forEach { part ->
                part.inlineData?.data?.let {
                    Log.d(TAG, "Playing received audio chunk.")
                    audioPlayer.playAudio(it)
                }
            }

            // End of Turn
            if (serverContent?.turnComplete == true) {
                Log.d(TAG, "Turn complete. Clearing buffers.")
                userInputBuffer.clear()
                modelTranslationBuffer.clear()
                lastSpeakerIsUser = null
            }

        } catch (e: Exception) {
            Log.e(TAG, "Error processing message: $text", e)
        }
    }

    private fun addOrUpdateTranslation(text: String, isUser: Boolean) {
        val currentTranslations = _uiState.value.translations.toMutableList()
        if (lastSpeakerIsUser == isUser && currentTranslations.isNotEmpty()) {
            currentTranslations[0] = text to isUser // List is reversed in UI, so update first element
        } else {
            currentTranslations.add(0, text to isUser) // Add to the "top"
        }
        _uiState.update { it.copy(translations = currentTranslations, showInfoText = currentTranslations.isEmpty()) }
    }

    // --- UI & UTILITY ---

    private fun updateStatus(line1: String, line2: String = "") {
        val newStatus = if (line2.isNotEmpty()) "$line1\n$line2" else line1
        _uiState.update {
            // Determine status text based on overall state
            val statusText = when {
                !it.isSessionActive && line1 == "Disconnected" -> "Status: Disconnected\nTap the microphone to connect"
                !it.isSessionActive && line1.startsWith("Connection lost") -> newStatus
                !it.isSessionActive -> "Status: $line1"
                !isServerReady -> "Status: $line1"
                it.isListening -> "Status: Listening...\nTap the microphone to stop"
                else -> "Status: Ready\nTap the microphone to speak"
            }
            it.copy(statusText = statusText)
        }
        Log.i(TAG, "Status Updated: $newStatus")
    }

    private fun updateToolbarText() {
        val toolbarText = "Model: ${selectedModel}\nAPI: ${selectedApiVersion?.value ?: "N/A"}"
        _uiState.update { it.copy(toolbarInfoText = toolbarText) }
    }

    private fun logToOverlay(message: String) {
        if (_uiState.value.showDebugOverlay) {
            val timestamp = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(Date())
            val newLog = "${_uiState.value.debugLog}[$timestamp] $message\n"
            _uiState.update { it.copy(debugLog = newLog) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.w(TAG, "ViewModel onCleared. Releasing resources.")
        audioPlayer.release()
        teardownSession(reconnect = false)
    }
}