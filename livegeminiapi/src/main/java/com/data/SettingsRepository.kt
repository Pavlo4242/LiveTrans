package com.data

import android.content.SharedPreferences
import com.Constants
import com.network.WebSocketClient

/**
 * A repository to abstract access to SharedPreferences for app settings.
 * This makes the ViewModel more testable and separates data access logic.
 */
class SettingsRepository(private val prefs: SharedPreferences) {

    fun getApiHost(): String = prefs.getString("api_host", "generativelanguage.googleapis.com") ?: "generativelanguage.googleapis.com"
    fun getSelectedModel(): String = prefs.getString("selected_model", "gemini-2.5-flash-preview-native-audio-dialog") ?: "gemini-2.5-flash-preview-native-audio-dialog"
    fun getVadSensitivity(): Int = prefs.getInt("vad_sensitivity_ms", 800)
    fun getApiVersion(): String = prefs.getString("api_version", "v1beta") ?: "v1beta"
    fun getApiKey(): String = prefs.getString("api_key", "") ?: ""
    fun getSessionHandle(): String? = prefs.getString("session_handle", null)
    fun getShowDebugOverlay(): Boolean = prefs.getBoolean("show_debug_overlay", false)

    fun saveSessionHandle(handle: String?) {
        prefs.edit().putString("session_handle", handle).apply()
    }

    fun getWebSocketConfig(sessionHandle: String?): WebSocketClient.WebSocketConfig {
        return WebSocketClient.WebSocketConfig(
            host = getApiHost(),
            modelName = getSelectedModel(),
            vadSilenceMs = getVadSensitivity(),
            apiVersion = getApiVersion(),
            apiKey = getApiKey(),
            sessionHandle = sessionHandle,
            systemInstruction = Constants.SYSTEM_INSTRUCTION
        )
    }
    fun setShowDebugOverlay(enabled: Boolean) {
        prefs.edit().putBoolean("show_debug_overlay", enabled).apply()
    }

    fun setVadSensitivity(value: Int) {
        prefs.edit().putInt("vad_sensitivity_ms", value).apply()
    }

    fun setApiHost(host: String) {
        prefs.edit().putString("api_host", host).apply()
    }

    fun setSelectedModel(model: String) {
        prefs.edit().putString("selected_model", model).apply()
    }

    fun setApiVersion(version: String) {
        prefs.edit().putString("api_version", version).apply()
    }

    fun setApiKey(key: String) {
        prefs.edit().putString("api_key", key).apply()
    }

}

