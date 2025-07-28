package com.viewmodel

import android.app.Application
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.ConnectionState
import com.data.ServerResponse
import com.data.SettingsRepository
import com.data.TranslationItem
import com.data.UiState
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.Constants
import com.livegemini.audio.AudioHandler
import com.network.WebSocketClient
import com.utils.AppLogger
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.Response
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(
    private val application: Application,
    private val audioHandler: AudioHandler,
    private val webSocketFactory: WebSocketClient.Companion,
    private val settingsRepository: SettingsRepository,
    private val appLogger: AppLogger
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<ViewEvent>()
    val events: SharedFlow<ViewEvent> = _events.asSharedFlow()

    private var webSocketClient: WebSocketClient? = null
    private var reconnectJob: Job? = null
    private var reconnectAttempts = 0
    private val gson = Gson()

    private val userInputBuffer = StringBuilder()
    private val modelTranslationBuffer = StringBuilder()
    private var lastSpeakerIsUser: Boolean? = null
    private var sessionHandle: String? = null

    init {
        appLogger.logInfo(TAG, "ViewModel Initialized")
        loadConfiguration()
        updateToolbarText()
        audioHandler.audioDataCallback = { audioData ->
            webSocketClient?.sendAudio(audioData)
        }
    }

    fun handleEvent(event: UserEvent) {
        when (event) {
            is UserEvent.ConnectToggleClicked -> handleConnectionToggle(event.force)
            UserEvent.MicClicked -> toggleRecording()
            UserEvent.DebugSettingsClicked -> _uiState.update { it.copy(showDebugSettingsDialog = true) }
            UserEvent.DismissDebugSettings -> _uiState.update { it.copy(showDebugSettingsDialog = false) }
            UserEvent.UserSettingsClicked -> _uiState.update { it.copy(showUserSettingsDialog = true) }
            UserEvent.DismissUserSettings -> _uiState.update { it.copy(showUserSettingsDialog = false) }
            UserEvent.SettingsSaved -> reloadConfiguration()
            UserEvent.ShareLogRequested -> handleShareLog()
            UserEvent.ClearLogRequested -> clearDebugLog()
            UserEvent.ForceReconnect -> handleForceReconnect()
            UserEvent.ClearDebugLog -> handleClearDebugLog()
            UserEvent.ShareDebugLog -> handleShareDebugLog()
            is UserEvent.ToggleDebugOverlay -> handleToggleDebugOverlay(event.enabled)
        }
    }

    private fun connect() {
        if (uiState.value.isSessionActive) return

        _uiState.update { it.copy(connectionState = ConnectionState.Connecting) }
        appLogger.logInfo(TAG, "Connecting...")

        webSocketClient = webSocketFactory.create(
            scope = viewModelScope,
            context = application,
            config = createWebSocketConfig(),
            listener = webSocketListener
        ).also { it.connect() }
    }

    private fun createWebSocketConfig(): WebSocketClient.WebSocketConfig {
        return WebSocketClient.WebSocketConfig(
            host = settingsRepository.getApiHost(),
            modelName = settingsRepository.getSelectedModel(),
            vadSilenceMs = settingsRepository.getVadSensitivity(),
            apiVersion = settingsRepository.getApiVersion(),
            apiKey = settingsRepository.getApiKey(),
            sessionHandle = sessionHandle,
            systemInstruction = Constants.SYSTEM_INSTRUCTION
        )
    }

    private fun handleConnectionToggle(force: Boolean) {
        if (force) {
            disconnect(reconnect = true)
            return
        }

        if (uiState.value.isSessionActive) {
            disconnect()
        } else {
            connect()
        }
    }

    private fun disconnect(reconnect: Boolean = false) {
        if (!reconnect) {
            reconnectJob?.cancel()
            reconnectAttempts = 0
        }

        webSocketClient?.disconnect()
        cleanupConnection()

        val newState = if (reconnect) ConnectionState.Connecting else ConnectionState.Idle
        _uiState.update { it.copy(connectionState = newState, isListening = false) }
        appLogger.logInfo(TAG, "Disconnected. Reconnect requested: $reconnect")

        if (reconnect) {
            viewModelScope.launch {
                delay(500)
                connect()
            }
        }
    }

    private val webSocketListener = object : WebSocketClient.WebSocketListener {
        override fun onOpen() {
            reconnectAttempts = 0
            reconnectJob?.cancel()
            _uiState.update { it.copy(connectionState = ConnectionState.Connected) }
            appLogger.logInfo(TAG, "WebSocket connection established")
        }

        override fun onSetupComplete() {
            appLogger.logDebug(TAG, "Server has confirmed setup is complete.")
        }

        override fun onMessage(text: String) = processServerMessage(text)

        override fun onClosing(code: Int, reason: String) {
            _uiState.update { it.copy(connectionState = ConnectionState.Idle) }
            if (code != 1000) {
                appLogger.logInfo(TAG, "WebSocket closing unexpectedly: $code $reason. Scheduling reconnect.")
                scheduleReconnect()
            } else {
                appLogger.logInfo(TAG, "WebSocket closed normally.")
            }
        }

        override fun onFailure(t: Throwable, response: Response?) {
            val errorMessage = when (response?.code) {
                401, 403 -> "Authentication failed. Check API Key."
                404 -> "Endpoint not found. Check API Host."
                else -> t.message ?: "Unknown connection error."
            }
            _uiState.update { it.copy(connectionState = ConnectionState.Failed(errorMessage)) }
            appLogger.logError(TAG, "WebSocket failure: $errorMessage", t)
            scheduleReconnect()
        }
    }

    private fun processServerMessage(text: String) {
        try {
            val response = gson.fromJson(text, ServerResponse::class.java)

            response.sessionResumptionUpdate?.let {
                if (it.resumable == true && it.newHandle != null) {
                    sessionHandle = it.newHandle
                    settingsRepository.saveSessionHandle(sessionHandle)
                }
            }
            processTranscription(response)
            if (response.serverContent?.turnComplete == true) {
                commitAndResetBuffers()
            }
        } catch (e: JsonSyntaxException) {
            appLogger.logError(TAG, "Failed to parse server message", e)
        }
    }

    private fun processTranscription(response: ServerResponse) {
        val userText = response.inputTranscription?.text
        val modelText = response.outputTranscription?.text

        if (userText != null) {
            if (lastSpeakerIsUser == false) commitAndResetBuffers()
            lastSpeakerIsUser = true
            userInputBuffer.append(userText)
            updateOrAddTranslation(userInputBuffer.toString().trim(), isUser = true)
        }

        if (modelText != null) {
            if (lastSpeakerIsUser == true) commitAndResetBuffers()
            lastSpeakerIsUser = false
            modelTranslationBuffer.append(modelText)
            updateOrAddTranslation(modelTranslationBuffer.toString().trim(), isUser = false)
        }
    }

    private fun toggleRecording() {
        if (uiState.value.isListening) {
            audioHandler.stopRecording()
            _uiState.update { it.copy(isListening = false) }
        } else {
            if (uiState.value.connectionState !is ConnectionState.Connected) {
                viewModelScope.launch { _events.emit(ViewEvent.ShowToast("Connect first to start listening")) }
                return
            }
            audioHandler.startRecording()
            _uiState.update { it.copy(isListening = true) }
        }
    }

    private fun updateOrAddTranslation(text: String, isUser: Boolean) {
        if (text.isBlank()) return

        val currentList = _uiState.value.translations.toMutableList()
        val lastItem = currentList.firstOrNull()

        if (lastItem?.isUser == isUser) {
            currentList[0] = lastItem.copy(text = text)
        } else {
            currentList.add(0, TranslationItem(text = text, isUser = isUser))
        }
        _uiState.update { it.copy(translations = currentList) }
    }

    private fun commitAndResetBuffers() {
        userInputBuffer.clear()
        modelTranslationBuffer.clear()
        lastSpeakerIsUser = null
    }

    private fun scheduleReconnect() {
        if (reconnectJob?.isActive == true || reconnectAttempts >= MAX_RECONNECT_ATTEMPTS) return

        reconnectAttempts++
        _uiState.update { it.copy(connectionState = ConnectionState.Reconnecting(reconnectAttempts)) }
        val delayMillis = (1000 * Math.pow(2.0, (reconnectAttempts - 1).toDouble())).toLong()

        reconnectJob = viewModelScope.launch {
            delay(delayMillis)
            connect()
        }
    }

    private fun loadConfiguration() {
        sessionHandle = settingsRepository.getSessionHandle()
        _uiState.update {
            it.copy(showDebugOverlay = settingsRepository.getShowDebugOverlay())
        }
    }

    private fun reloadConfiguration() {
        loadConfiguration()
        updateToolbarText()
        if (uiState.value.isSessionActive) {
            viewModelScope.launch {
                _events.emit(ViewEvent.ShowToast("Settings updated. Reconnect to apply."))
            }
        }
    }

    private fun updateToolbarText() {
        val model = settingsRepository.getSelectedModel()
        val apiVersion = settingsRepository.getApiVersion()
        _uiState.update { it.copy(toolbarInfoText = "Model: $model\nAPI: $apiVersion") }
    }

    private fun handleShareLog() {
        viewModelScope.launch {
            try {
                val logFile = appLogger.getLogFile()
                _events.emit(ViewEvent.ShareLogFile(logFile))
            } catch (e: Exception) {
                appLogger.logError(TAG, "Failed to share log file", e)
                _events.emit(ViewEvent.ShowError("No log file available"))
            }
        }
    }

    private fun clearDebugLog() {
        _uiState.update { it.copy(debugLog = "") }
    }

    private fun handleForceReconnect() {
        disconnect(reconnect = true)
    }

    private fun handleClearDebugLog() {
        _uiState.update { it.copy(debugLog = "") }
    }

    private fun handleShareDebugLog() {
        viewModelScope.launch {
            try {
                val logFile = createDebugLogFile()
                _events.emit(ViewEvent.ShareDebugLogFile(logFile))
            } catch (e: Exception) {
                _events.emit(ViewEvent.ShowError("Failed to create debug log"))
            }
        }
    }

    private fun createDebugLogFile(): Uri {
        val logFile = File(application.cacheDir, "debug_log.txt")
        logFile.writeText(_uiState.value.debugLog)
        return FileProvider.getUriForFile(
            application,
            "${application.packageName}.provider",
            logFile
        )
    }

    private fun handleToggleDebugOverlay(enabled: Boolean) {
        _uiState.update { it.copy(showDebugOverlay = enabled) }
        settingsRepository.setShowDebugOverlay(enabled)
    }

    private fun logDebug(message: String) {
        if (_uiState.value.showDebugOverlay) {
            val timestamp = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(Date())
            _uiState.update {
                it.copy(debugLog = "${it.debugLog}[$timestamp] $message\n")
            }
            appLogger.logDebug(TAG, message)
        }
    }

    private fun cleanupConnection() {
        webSocketClient = null
        reconnectJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        disconnect()
        audioHandler.release()
        appLogger.logInfo(TAG, "ViewModel cleared")
    }

    sealed class UserEvent {
        data class ConnectToggleClicked(val force: Boolean = false) : UserEvent()
        object MicClicked : UserEvent()
        object DebugSettingsClicked : UserEvent()
        object DismissDebugSettings : UserEvent()
        object UserSettingsClicked : UserEvent()
        object DismissUserSettings : UserEvent()
        object SettingsSaved : UserEvent()
        object ShareLogRequested : UserEvent()
        object ClearLogRequested : UserEvent()
        object ForceReconnect : UserEvent()
        object ClearDebugLog : UserEvent()
        object ShareDebugLog : UserEvent()
        data class ToggleDebugOverlay(val enabled: Boolean) : UserEvent()
    }

    sealed class ViewEvent {
        data class ShowToast(val message: String) : ViewEvent()
        data class ShowError(val message: String) : ViewEvent()
        data class ShareLogFile(val uri: Uri) : ViewEvent()
        data class ShareDebugLogFile(val uri: Uri) : ViewEvent()
    }

    companion object {
        private const val TAG = "MainViewModel"
        private const val MAX_RECONNECT_ATTEMPTS = 5
    }
}