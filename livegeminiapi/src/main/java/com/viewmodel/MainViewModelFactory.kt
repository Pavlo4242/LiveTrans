package com.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.audio.AudioHandler
import com.network.WebSocketClient

class MainViewModelFactory(
    private val audioHandler: AudioHandler,
    private val webSocketFactory: WebSocketClient.Factory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(audioHandler, webSocketFactory) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}