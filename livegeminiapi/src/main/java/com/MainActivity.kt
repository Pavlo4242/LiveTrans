package com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModelProvider
import com.livegemini.audio.AudioHandler
import com.ui.screens.MainScreen
import com.ui.screens.MainScreenContent // Keep this import if MainScreenContent is still used directly
import com.viewmodel.MainViewModel
import com.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var audioHandler: AudioHandler // Kept for clarity, though its lifecycle is tied to ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // AudioHandler is initialized here.
        // It will be passed to the ViewModel,
        // which will manage its lifecycle (start, stop, release).
        audioHandler = AudioHandler(application) // Correctly uses application context

        // The factory provides dependencies to the ViewModel.
        // NOTE: The WebSocketClient.Companion part is unusual.
        // We'll assume your factory is set up to handle it.
        // A cleaner approach might be to not pass the companion object.
        val factory = MainViewModelFactory(
            application,
            audioHandler
            // Passing WebSocketClient.Companion is not necessary if the ViewModel
            // can create the client directly, which our revised ViewModel now does.
            // You may need to adjust your MainViewModelFactory accordingly.
        )

        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        setContent {
            // Your app's theme should wrap the main screen.
            MaterialTheme { // Or your specific app theme
                // CORRECTED: Pass the viewModel directly to MainScreen
                MainScreen(viewModel = viewModel) // [cite: 2]
            }
        }
    } // <- CORRECTED: The brace for onCreate ends here.
    override fun onDestroy() {
        super.onDestroy()
        // It's correct that you don't need to manually release resources here.
        // The ViewModel's onCleared() method, which is tied to the Activity's
        // lifecycle, is the proper place for cleanup to avoid memory leaks.
    }
}