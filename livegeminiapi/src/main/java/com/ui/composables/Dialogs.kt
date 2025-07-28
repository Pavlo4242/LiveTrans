package com.ui.composables
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.viewmodel.MainViewModel
import androidx.compose.material3.Switch
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun UserSettingsDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("User Settings", style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(16.dp))
                Text("Feature settings will be available here.", style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(24.dp))
                TextButton(onClick = onDismissRequest) {
                    Text("Close")
                }
            }
        }
    }
}
// 1. State data class for preview
data class DebugSettingsState(
    val showDebugOverlay: Boolean = false
)

// 2. Preview parameter provider
class DebugSettingsStateProvider : PreviewParameterProvider<DebugSettingsState> {
    override val values: Sequence<DebugSettingsState>
        get() = sequenceOf(
            DebugSettingsState(showDebugOverlay = false),
            DebugSettingsState(showDebugOverlay = true)
        )
}

// 3. Stateless composable

@Composable
fun DebugSettingsDialogStateless(
    state: DebugSettingsState,
    onToggleDebugOverlay: (Boolean) -> Unit = {},
    onForceReconnect: () -> Unit = {},
    onShareDebugLog: () -> Unit = {},
    onClearDebugLog: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Debug Settings",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Show Debug Overlay",
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = state.showDebugOverlay,
                        onCheckedChange = onToggleDebugOverlay
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        onForceReconnect()
                        onDismissRequest()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Force Reconnect")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onShareDebugLog,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Share Debug Log")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onClearDebugLog,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Clear Debug Log")
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(
                    onClick = onDismissRequest,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Close")
                }
            }
        }
    }
}

// 4. Preview composable
@Preview
@Composable
fun DebugSettingsDialogPreview(
    @PreviewParameter(DebugSettingsStateProvider::class) state: DebugSettingsState
) {
    MaterialTheme {
        DebugSettingsDialogStateless(
            state = state,
            onToggleDebugOverlay = { println("Debug overlay: it") },
            onForceReconnect = { println("Force reconnect clicked") },
            onShareDebugLog = { println("Share debug log clicked") },
            onClearDebugLog = { println("Clear debug log clicked") },
            onDismissRequest = { println("Dialog dismissed") }
        )
    }
}


// 5. Wrapper for actual ViewModel usage
@Composable
fun DebugSettingsDialog(
    viewModel: MainViewModel,
    onDismissRequest: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    DebugSettingsDialogStateless(
        state = DebugSettingsState(
            showDebugOverlay = uiState.showDebugOverlay
        ),
        onToggleDebugOverlay = { enabled ->
            viewModel.handleEvent(MainViewModel.UserEvent.ToggleDebugOverlay(enabled))
        },
        onForceReconnect = {
            viewModel.handleEvent(MainViewModel.UserEvent.ForceReconnect)
        },
        onShareDebugLog = {
            viewModel.handleEvent(MainViewModel.UserEvent.ShareDebugLog)
        },
        onClearDebugLog = {
            viewModel.handleEvent(MainViewModel.UserEvent.ClearDebugLog)
        },
        onDismissRequest = onDismissRequest
    )
}

@Preview
@Composable
fun UserSettingsDialogPreview() {
    MaterialTheme {
        UserSettingsDialog(
            onDismissRequest = {}
        )
    }
}