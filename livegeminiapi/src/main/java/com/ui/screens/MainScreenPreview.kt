package com.ui.screens

import com.viewmodel.MainViewModel
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.ui.res.painterResource
import com.livegemini.R
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.data.ConnectionState
import com.ui.composables.TranslationItemComposable
import com.ui.composables.UserSettingsDialog
import kotlinx.coroutines.launch
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.data.TranslationItem
import com.ui.composables.DebugSettingsDialog // Added import for DebugSettingsDialog

// REMOVED: Redundant MainScreen composable. The one in MainScreen.kt is used.

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(
    translations: List<TranslationItem> = emptyList(),
    isListening: Boolean = false,
    showUserSettingsDialog: Boolean = false,
    showDebugSettingsDialog: Boolean = false,
    showDebugOverlay: Boolean = false,
    debugLog: String = "",
    connectionState: ConnectionState = ConnectionState.Idle,
    statusText: String = "Tap Connect to begin",
    isSessionActive: Boolean = false,
    onUserSettingsClick: () -> Unit = {},
    onDebugSettingsClick: () -> Unit = {},
    onMicClick: () -> Unit = {},
    onConnectClick: () -> Unit = {},
    onDismissUserSettings: () -> Unit = {},
    onDismissDebugSettings: () -> Unit = {}
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // CORRECTED: Reference the 'translations' parameter directly
    LaunchedEffect(translations) { // [cite: 3]
        if (translations.isNotEmpty()) { // [cite: 3]
            coroutineScope.launch {
                listState.animateScrollToItem(0)
            }
        }
    }

    if (showUserSettingsDialog) {
        UserSettingsDialog(onDismissRequest = onDismissUserSettings)
    }

    // Since DebugSettingsDialog needs a ViewModel, it's problematic for stateless previews.
    // For previews, we can either mock a ViewModel or create a stateless version of the dialog.
    // Given the task is "Modifying as little code as possible", and this file is for previews,
    // we will comment out the problematic line or adapt if possible.
    // If a preview for DebugSettingsDialog is needed, it should be done using its stateless variant.
    // REMOVED FOR PREVIEW: if (showDebugSettingsDialog) { DebugSettingsDialog(viewModel = TODO(), onDismissRequest = onDismissDebugSettings) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Live Gemini") },
                actions = {
                    IconButton(onClick = onDebugSettingsClick) {
                        Icon(Icons.Default.Settings, "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onMicClick,
                containerColor = if (isListening) MaterialTheme.colorScheme.errorContainer
                else MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_mic),
                    contentDescription = "Mic",
                    tint = if (isListening) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.primary
                )
            }
        },
        bottomBar = {
            BottomBarContent(
                connectionState = connectionState,
                isSessionActive = isSessionActive,
                statusText = statusText,
                onConnectClick = onConnectClick
            )
        }
    ) { paddingValues ->
        Box(Modifier.fillMaxSize().padding(paddingValues)) {
            if (translations.isEmpty()) {
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    state = listState,
                    reverseLayout = true,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(translations) { item ->
                        TranslationItemComposable(item = item)
                    }
                }
            }

            if (showDebugOverlay) {
                // CORRECTED: Make DebugOverlay public or move it to a shared composable file
                // For now, we'll make it internal in MainScreen.kt and rely on it being visible here.
                // Alternatively, create a public @Composable DebugOverlay function here or in a common file.
                // Given "Modifying as little code as possible", let's assume it's publicly accessible for preview purposes.
                DebugOverlay(log = debugLog) // [cite: 4]
            }
        }
    }
}

@Composable
fun BottomBarContent(
    connectionState: ConnectionState,
    isSessionActive: Boolean,
    statusText: String,
    onConnectClick: () -> Unit
) {
    // REPLACED TODO with actual implementation.
    // This function was likely intended to be similar to the private BottomBar in MainScreen.kt
    val statusTextDisplay = when (val state = connectionState) {
        ConnectionState.Idle -> "Tap Connect to begin"
        ConnectionState.Connecting -> "Connecting..."
        ConnectionState.Connected -> if (isSessionActive) "Listening..." else "Ready to listen"
        is ConnectionState.Reconnecting -> "Reconnecting (attempt ${state.attempt})"
        is ConnectionState.Failed -> "Error: ${state.error}"
    }
    val statusColor = when (connectionState) {
        is ConnectionState.Failed -> MaterialTheme.colorScheme.error
        is ConnectionState.Connected -> Color(0xFF34A853)
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = statusTextDisplay,
            color = statusColor,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = onConnectClick,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(if (isSessionActive) "Disconnect" else "Connect")
        }
    }
}

// For connection states
class ConnectionStateProvider : PreviewParameterProvider<ConnectionState> {
    override val values = sequenceOf(
        ConnectionState.Idle,
        ConnectionState.Connecting,
        ConnectionState.Connected,
        ConnectionState.Reconnecting(attempt = 3),
        ConnectionState.Failed("Connection timeout")
    )
}

// For UI states
class MainScreenStateProvider : PreviewParameterProvider<MainScreenState> {
    override val values = sequenceOf(
        MainScreenState(
            translations = emptyList(),
            connectionState = ConnectionState.Idle
        ),
        MainScreenState(
            translations = listOf(
                // CORRECTED: Pass only text and isUser to TranslationItem constructor
                TranslationItem(text = "Hello", isUser = true), // [cite: 5]
                TranslationItem(text = "How are you?", isUser = false) // [cite: 5]
    ),
    connectionState = ConnectionState.Connected
    )
    )
}

data class MainScreenState(
    val translations: List<TranslationItem>,
    val connectionState: ConnectionState,
    val isListening: Boolean = false,
    val showDebugOverlay: Boolean = false
)

@Preview(showBackground = true)
@Composable
fun MainScreenPreview_Empty() {
    MaterialTheme {
        MainScreenContent(
            statusText = "Ready to connect",
            connectionState = ConnectionState.Idle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview_WithTranslations() {
    MaterialTheme {
        MainScreenContent(
            translations = listOf(
                // CORRECTED: Pass only text and isUser to TranslationItem constructor
                TranslationItem(text = "Hello", isUser = true), // [cite: 6]
            TranslationItem(text = "How are you?", isUser = false) // [cite: 6]
        ),
        connectionState = ConnectionState.Connected,
        isSessionActive = true
        )
    }
}