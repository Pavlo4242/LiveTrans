package com.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.livegemini.audio.AudioHandler
import com.data.SettingsRepository
import com.network.WebSocketClient
import com.utils.AppLogger

class MainViewModelFactory(
    private val application: Application,
    private val audioHandler: AudioHandler
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            // The factory is responsible for creating the dependencies.
            // Let's create them in the correct order.

            // 1. AppLogger needs a context. The application is a context.
            val appLogger = AppLogger(application)

            // 2. SettingsRepository needs SharedPreferences. We get that from the application context.
            val sharedPreferences = application.getSharedPreferences("BwctransPrefs", Context.MODE_PRIVATE)
            val settingsRepository = SettingsRepository(sharedPreferences) // Pass the correct object.

            // 3. Now, we can create the MainViewModel with all its dependencies.
            return MainViewModel(
                application = application,
                audioHandler = audioHandler,
                webSocketFactory = WebSocketClient.Companion, // Assuming this pattern is intended
                settingsRepository = settingsRepository,     // Provide the created repository
                appLogger = appLogger                        // Provide the created logger
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}