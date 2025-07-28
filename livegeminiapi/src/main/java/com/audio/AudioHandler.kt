package com.livegemini.audio

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.media.audiofx.AcousticEchoCanceler
import android.media.audiofx.AutomaticGainControl
import android.media.audiofx.NoiseSuppressor
import android.os.Process
import android.util.Log
import androidx.core.app.ActivityCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * Handles audio recording from the device's microphone.
 * It encapsulates all AudioRecord logic and provides audio data through a simple callback.
 *
 * This class is self-contained and manages its own CoroutineScope, which must be
 * explicitly cleaned up by calling release() when the handler is no longer needed.
 */
class AudioHandler(private val context: Context) {

    /**
     * The owner of this handler (the ViewModel) sets this callback
     * to receive audio data chunks as they are recorded.
     */
    var audioDataCallback: ((ByteArray) -> Unit)? = null

    private var audioRecord: AudioRecord? = null
    private var isRecording = false

    // This scope is dedicated to audio processing and must be cancelled via release().
    private val audioScope = CoroutineScope(Dispatchers.IO)

    private var noiseSuppressor: NoiseSuppressor? = null
    private var agc: AutomaticGainControl? = null
    private var aec: AcousticEchoCanceler? = null

    companion object {
        private const val SAMPLE_RATE = 16000
        private const val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO
        private const val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
        private const val TAG = "AudioHandler"
    }

    fun startRecording() {
        if (isRecording) {
            Log.w(TAG, "Recording is already active.")
            return
        }

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.e(TAG, "RECORD_AUDIO permission not granted. Cannot start recording.")
            // Consider sending an event back to the ViewModel to request permission.
            return
        }

        val bufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, CHANNEL_CONFIG, AUDIO_FORMAT)
        if (bufferSize == AudioRecord.ERROR_BAD_VALUE) {
            Log.e(TAG, "Invalid AudioRecord parameters.")
            return
        }

        audioRecord = AudioRecord.Builder()
            .setAudioSource(MediaRecorder.AudioSource.MIC)
            .setAudioFormat(
                AudioFormat.Builder()
                    .setEncoding(AUDIO_FORMAT)
                    .setSampleRate(SAMPLE_RATE)
                    .setChannelMask(CHANNEL_CONFIG)
                    .build()
            )
            .setBufferSizeInBytes(bufferSize)
            .build()

        initializeAudioEffects()

        audioRecord?.startRecording()
        isRecording = true
        Log.d(TAG, "Recording started.")

        audioScope.launch {
            Process.setThreadPriority(Process.THREAD_PRIORITY_AUDIO)
            val audioBuffer = ByteArray(bufferSize)
            while (isActive && isRecording) {
                val readResult = audioRecord?.read(audioBuffer, 0, audioBuffer.size) ?: 0
                if (readResult > 0) {
                    // CORRECT: Invoke the public callback property, not the constructor parameter.
                    audioDataCallback?.invoke(audioBuffer.copyOf(readResult))
                }
            }
            Log.d(TAG, "Audio reading loop finished.")
        }
    }

    fun stopRecording() {
        if (!isRecording) return

        isRecording = false
        // The recording loop will terminate on its next iteration.

        // Safely stop and release the AudioRecord instance.
        audioRecord?.apply {
            try {
                if (recordingState == AudioRecord.RECORDSTATE_RECORDING) {
                    stop()
                }
                release()
            } catch (e: Exception) {
                Log.e(TAG, "Exception while stopping AudioRecord.", e)
            }
        }
        audioRecord = null

        releaseAudioEffects()
        Log.d(TAG, "Recording stopped and resources released.")
    }

    /**
     * Must be called when the AudioHandler is no longer needed (e.g., in ViewModel's onCleared)
     * to prevent coroutine and resource leaks.
     */
    fun release() {
        stopRecording()
        audioScope.cancel() // CRITICAL: Prevent Coroutine leak.
        Log.d(TAG, "AudioHandler fully released and scope cancelled.")
    }

    private fun initializeAudioEffects() {
        val sessionId = audioRecord?.audioSessionId ?: 0
        if (sessionId != 0) {
            if (NoiseSuppressor.isAvailable()) {
                noiseSuppressor = NoiseSuppressor.create(sessionId).apply { enabled = true }
                Log.d(TAG, "NoiseSuppressor enabled.")
            }
            if (AutomaticGainControl.isAvailable()) {
                agc = AutomaticGainControl.create(sessionId).apply { enabled = true }
                Log.d(TAG, "AutomaticGainControl enabled.")
            }
            if (AcousticEchoCanceler.isAvailable()) {
                aec = AcousticEchoCanceler.create(sessionId).apply { enabled = true }
                Log.d(TAG, "AcousticEchoCanceler enabled.")
            }
        }
    }

    private fun releaseAudioEffects() {
        noiseSuppressor?.release()
        agc?.release()
        aec?.release()
        noiseSuppressor = null
        agc = null
        aec = null
    }
}