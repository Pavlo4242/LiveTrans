package com.livegemini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Modifier // Add this import
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import com.livegemini.audio.AudioHandler
import com.livegemini.network.WebSocketClient
import com.livegemini.viewmodel.MainViewModel
import com.livegemini.viewmodel.MainViewModelFactory
import androidx.compose.material3.MaterialTheme // Import your Material Theme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var audioHandler: AudioHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        audioHandler = AudioHandler(applicationContext) { audioData ->
            // Pass audio data to ViewModel to send via WebSocket
            // This is handled internally by MainViewModel via audioHandler.startRecording() callback
        }

        // Initialize WebSocketClient.Factory with applicationContext
        val webSocketClientFactory = WebSocketClient.Factory(applicationContext)

        val factory = MainViewModelFactory(application, audioHandler, webSocketClientFactory)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        setContent {
                TranslationLog(viewModel = yourViewModel) // Call your Composable here


            BwcTransTheme {
                val uiState by viewModel.uiState.collectAsState()

                Column {
                    StatusBar(
                        statusText = uiState.statusText,
                        toolbarInfoText = uiState.toolbarInfoText,
                        isSessionActive = uiState.isSessionActive,
                        onConnectDisconnect = { viewModel.handleEvent(ViewEvent.ConnectClicked) }
                    )

                    TranslationList(
                        translations = uiState.translations,
                        modifier = Modifier.weight(1f)
                    )

                    MicButton(
                        isListening = uiState.isListening,
                        enabled = uiState.isMicButtonEnabled,
                        onClick = { viewModel.handleEvent(ViewEvent.MicClicked) }
                    )
                    override fun onDestroy() {
                        super.onDestroy()
                        // ViewModel onCleared() handles audioHandler.release() and websocket disconnect
                    }
                } }
        }
        }
    }
}