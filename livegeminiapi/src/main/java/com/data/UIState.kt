package com.data

// FIXED: This file now correctly uses the ConnectionState sealed class.
data class UiState(
    val connectionState: ConnectionState = ConnectionState.Idle,
    val toolbarInfoText: String = "Model: N/A\nAPI: N/A",
    val isListening: Boolean = false,
    val statusText: String = "Tap the microphone to connect",
    val translations: List<TranslationItem> = emptyList(),
    val isMicButtonEnabled: Boolean = true,
    val showDebugOverlay: Boolean = false,
    val debugLog: String = "",
    val showUserSettingsDialog: Boolean = false,
    val showDebugSettingsDialog: Boolean = false
) {
    val isSessionActive: Boolean
        get() = connectionState is ConnectionState.Connected ||
                connectionState is ConnectionState.Connecting ||
                connectionState is ConnectionState.Reconnecting
}