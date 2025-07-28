package com.network

import android.content.Context
import android.util.Base64
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.Date
import java.util.concurrent.TimeUnit

// FIXED: This version is complete and self-contained.
class WebSocketClient private constructor(
    private val scope: CoroutineScope,
    private val context: Context,
    private val config: WebSocketConfig,
    private val listener: WebSocketListener
) {
    private var webSocket: WebSocket? = null
    private var isSetupComplete = false
    private var isConnected = false
    private var logFileWriter: PrintWriter? = null
    private var logFile: File? = null

    private val client = OkHttpClient.Builder()
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .pingInterval(30, TimeUnit.SECONDS)
        .addInterceptor(createLoggingInterceptor())
        .build()

    fun connect() {
        if (isConnected) return
        scope.launch {
            initializeLogging()
            initializeWebSocket()
        }
    }

    fun sendAudio(audioData: ByteArray) {
        if (!isReadyToSend()) return
        scope.launch {
            try {
                val message = createAudioMessage(audioData)
                logMessage("OUTGOING AUDIO", "length=${audioData.size}")
                webSocket?.send(message)
            } catch (e: Exception) {
                logError("Failed to send audio", e)
                listener.onFailure(e, null)
            }
        }
    }

    fun disconnect() {
        scope.launch { cleanupResources() }
    }

    fun getLogFile(): File? = logFile
    fun isReadyToSend(): Boolean = isConnected && isSetupComplete

    private fun initializeLogging() {
        try {
            val logDir =
                File(context.getExternalFilesDir(null), "websocket_logs").apply { mkdirs() }
            logFile = File(logDir, "session_${System.currentTimeMillis()}.log").apply {
                logFileWriter = PrintWriter(FileWriter(this, true), true)
                logMessage("SESSION START", "--- Session Started ${Date()} ---")
            }
        } catch (e: Exception) {
            logError("Failed to initialize logging", e)
            listener.onFailure(e, null)
        }
    }

    private fun initializeWebSocket() {
        val request = Request.Builder().url(buildWebSocketUrl()).build()
        webSocket = client.newWebSocket(request, object : okhttp3.WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                logMessage("CONNECTED", "HTTP ${response.code}")
                isConnected = true
                sendConfiguration()
                listener.onOpen()
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                if (text.contains("setupComplete")) listener.onSetupComplete()
                listener.onMessage(text)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                cleanupResources()
                listener.onClosing(code, reason)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                cleanupResources()
                listener.onFailure(t, response)
            }
        })
    }

    private fun sendConfiguration() {
        val configMessage = Gson().toJson(config.createSetupMessage())
        logMessage("CONFIG SENT", configMessage.take(500))
        webSocket?.send(configMessage)
    }

    private fun cleanupResources() {
        webSocket?.close(1000, "Normal closure")
        webSocket = null
        logFileWriter?.close()
        logFileWriter = null
        isConnected = false
        isSetupComplete = false
    }

    private fun createAudioMessage(audioData: ByteArray): String = Gson().toJson(
        mapOf(
            "realtimeInput" to mapOf(
                "audio" to mapOf(
                    "data" to Base64.encodeToString(
                        audioData,
                        Base64.NO_WRAP
                    ), "mime_type" to "audio/pcm;rate=16000"
                )
            )
        )
    )

    private fun buildWebSocketUrl(): String =
        "wss://${config.host}/ws/google.ai.generativelanguage.${config.apiVersion}.GenerativeService.BidiGenerateContent?key=${config.apiKey}"

    private fun createLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> logMessage("OkHttp", message) }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun logMessage(tag: String, message: String) =
        logFileWriter?.println("[$tag]: $message")

    private fun logError(context: String, error: Throwable) =
        logFileWriter?.println("ERROR [$context]: ${error.message}")

    interface WebSocketListener {
        fun onOpen()
        fun onMessage(text: String)
        fun onClosing(code: Int, reason: String)
        fun onFailure(t: Throwable, response: Response?)
        fun onSetupComplete()
    }

    data class WebSocketConfig(
        val host: String,
        val modelName: String,
        val vadSilenceMs: Int,
        val apiVersion: String,
        val apiKey: String,
        val sessionHandle: String?,
        val systemInstruction: String
    ) {
        fun createSetupMessage(): Map<String, Any> =
            mapOf("setup" to mutableMapOf<String, Any>().apply {
                put("model", "models/$modelName")
                put("generationConfig", mapOf("responseModalities" to listOf("AUDIO")))
                put(
                    "systemInstruction",
                    mapOf(
                        "parts" to systemInstruction.split(Regex("\\n+"))
                            .map { mapOf("text" to it.trim()) })
                )
                sessionHandle?.let { put("sessionResumption", mapOf("handle" to it)) }
            })
    }

    companion object {
        fun create(
            scope: CoroutineScope,
            context: Context,
            config: WebSocketConfig,
            listener: WebSocketListener
        ): WebSocketClient = WebSocketClient(scope, context, config, listener)
    }
}
