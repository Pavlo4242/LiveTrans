import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.AndroidViewBinding // If still using some XML
import com.livegemini.viewmodel.MainViewModel // Your ViewModel
import com.livegemini.databinding.ActivityMainBinding // If still using some XML
import androidx.compose.material3.Scaffold // Or other top-level layout
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.icons.filled.Mic
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color // For custom colors
import androidx.compose.ui.res.stringResource // For strings from resources
import androidx.compose.ui.res.painterResource // For drawable icons
import com.livegemini.R // Assuming R.string.app_name etc. exist
import com.livegemini.data.UiState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.style.TextAlign


@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.titleLarge)
                        Text(text = uiState.toolbarInfoText, style = MaterialTheme.typography.labelSmall)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle settings click */ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_settings), contentDescription = "Settings") // Use painterResource for custom drawables
                    }
                    IconButton(onClick = { /* Handle history click */ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_history), contentDescription = "History") // Use painterResource for custom drawables
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.handleEvent(MainViewModel.UserEvent.MicClicked) },
                modifier = Modifier.padding(16.dp),
                containerColor = if (uiState.isListening) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary // Red for listening, primary otherwise
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_mic), contentDescription = "Mic") // Use painterResource for custom drawables
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = uiState.statusText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = when {
                        uiState.statusText.contains("error", ignoreCase = true) -> Color.Red
                        uiState.isListening -> Color.Green
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    textAlign = TextAlign.Center
                )
                // Add debug settings button, connect/disconnect button if needed.
                // For simplicity, they are omitted in this basic example.
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            if (uiState.translations.isEmpty()) {
                Text(
                    text = uiState.statusText, // Or a separate "Tap the mic" info text
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 16.dp)
                )
            } else {
                LazyColumn(
                    state = listState,
                    reverseLayout = true, // To show newest items at the bottom
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(uiState.translations) { (text, isUser) ->
                        TranslationItemComposable(item = TranslationItem(text = text, isUser = isUser))
                    }
                }
            }
        }

        // Handle debug overlay visibility
        if (uiState.showDebugOverlay) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomStart)
                    .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent black background
                    .padding(8.dp)
            ) {
                Text(
                    text = uiState.debugLog,
                    color = Color.Green,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }

    // Scroll to the latest message whenever new messages arrive
    LaunchedEffect(uiState.translations.size) {
        if (uiState.translations.isNotEmpty()) {
            listState.animateScrollToItem(0) // Scroll to the first (newest) item
        }
    }
}