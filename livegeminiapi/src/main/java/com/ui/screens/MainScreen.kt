package com.ui.screens

import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.data.ConnectionState
import com.data.UiState
import com.ui.composables.DebugSettingsDialog
import com.ui.composables.TranslationItemComposable
import com.ui.composables.UserSettingsDialog
import com.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) { // [cite: 1]
    val uiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiState.translations) {
        if (uiState.translations.isNotEmpty()) {
            coroutineScope.launch {
                listState.animateScrollToItem(0)
            }
        }
    }

    if (uiState.showUserSettingsDialog) {
        UserSettingsDialog(onDismissRequest = { viewModel.handleEvent(MainViewModel.UserEvent.DismissUserSettings) })
    }

    if (uiState.showDebugSettingsDialog) {
        DebugSettingsDialog(
            viewModel = viewModel,
            onDismissRequest = { viewModel.handleEvent(MainViewModel.UserEvent.DismissDebugSettings) }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(
                        onClick = { viewModel.handleEvent(MainViewModel.UserEvent.DebugSettingsClicked) }
                    ) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.handleEvent(MainViewModel.UserEvent.MicClicked) },
                containerColor = if (uiState.isListening) MaterialTheme.colorScheme.errorContainer
                else MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_mic), // Changed from imageVector to painterResource
                    contentDescription = "Mic",
                    tint = if (uiState.isListening) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.primary
                )
            }
        },
        bottomBar = { BottomBar(uiState = uiState) { viewModel.handleEvent(MainViewModel.UserEvent.ConnectToggleClicked(false)) } }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (uiState.translations.isEmpty()) {
                Text(
                    text = uiState.statusText,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 24.dp)
                )
            } else {
                LazyColumn(
                    state = listState,
                    reverseLayout = true,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(items = uiState.translations, key = { it.id }) { item ->
                        TranslationItemComposable(item = item)
                    }
                }
            }

            if (uiState.showDebugOverlay) {
                DebugOverlay(log = uiState.debugLog)
            }
        }
    }
}

@Composable
private fun BottomBar(uiState: UiState, onConnectClick: () -> Unit) {
    val statusText = when (val state = uiState.connectionState) {
        ConnectionState.Idle -> "Tap Connect to begin"
        ConnectionState.Connecting -> "Connecting..."
        ConnectionState.Connected -> if (uiState.isListening) "Listening..." else "Ready to listen"
        is ConnectionState.Reconnecting -> "Reconnecting (attempt ${state.attempt})"
        is ConnectionState.Failed -> "Error: ${state.error}"
    }
    val statusColor = when (uiState.connectionState) {
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
            text = statusText,
            color = statusColor,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = onConnectClick,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(if (uiState.isSessionActive) "Disconnect" else "Connect")
        }
    }
}

@Composable
 fun BoxScope.DebugOverlay(log: String) {
    Box(
        modifier = Modifier
            .align(Alignment.BottomStart)
            .fillMaxWidth()
            .heightIn(max = 200.dp)
            .background(Color.Black.copy(alpha = 0.6f))
            .padding(8.dp)
    ) {
        LazyColumn(reverseLayout = true) {
            item {
                Text(
                    text = log,
                    color = Color.Green,
                    fontFamily = FontFamily.Monospace,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}