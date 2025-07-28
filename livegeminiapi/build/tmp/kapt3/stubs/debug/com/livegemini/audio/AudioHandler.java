package com.livegemini.audio;

/**
 * Handles audio recording from the device's microphone.
 * It encapsulates all AudioRecord logic and provides audio data through a simple callback.
 *
 * This class is self-contained and manages its own CoroutineScope, which must be
 * explicitly cleaned up by calling release() when the handler is no longer needed.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0006\u0010\u001a\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\fH\u0002J\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/livegemini/audio/AudioHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "aec", "Landroid/media/audiofx/AcousticEchoCanceler;", "agc", "Landroid/media/audiofx/AutomaticGainControl;", "audioDataCallback", "Lkotlin/Function1;", "", "", "getAudioDataCallback", "()Lkotlin/jvm/functions/Function1;", "setAudioDataCallback", "(Lkotlin/jvm/functions/Function1;)V", "audioRecord", "Landroid/media/AudioRecord;", "audioScope", "Lkotlinx/coroutines/CoroutineScope;", "isRecording", "", "noiseSuppressor", "Landroid/media/audiofx/NoiseSuppressor;", "initializeAudioEffects", "release", "releaseAudioEffects", "startRecording", "stopRecording", "Companion", "livegeminiapi_debug"})
public final class AudioHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    /**
     * The owner of this handler (the ViewModel) sets this callback
     * to receive audio data chunks as they are recorded.
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> audioDataCallback;
    @org.jetbrains.annotations.Nullable()
    private android.media.AudioRecord audioRecord;
    private boolean isRecording = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope audioScope = null;
    @org.jetbrains.annotations.Nullable()
    private android.media.audiofx.NoiseSuppressor noiseSuppressor;
    @org.jetbrains.annotations.Nullable()
    private android.media.audiofx.AutomaticGainControl agc;
    @org.jetbrains.annotations.Nullable()
    private android.media.audiofx.AcousticEchoCanceler aec;
    private static final int SAMPLE_RATE = 16000;
    private static final int CHANNEL_CONFIG = android.media.AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = android.media.AudioFormat.ENCODING_PCM_16BIT;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AudioHandler";
    @org.jetbrains.annotations.NotNull()
    public static final com.livegemini.audio.AudioHandler.Companion Companion = null;
    
    public AudioHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * The owner of this handler (the ViewModel) sets this callback
     * to receive audio data chunks as they are recorded.
     */
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<byte[], kotlin.Unit> getAudioDataCallback() {
        return null;
    }
    
    /**
     * The owner of this handler (the ViewModel) sets this callback
     * to receive audio data chunks as they are recorded.
     */
    public final void setAudioDataCallback(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> p0) {
    }
    
    public final void startRecording() {
    }
    
    public final void stopRecording() {
    }
    
    /**
     * Must be called when the AudioHandler is no longer needed (e.g., in ViewModel's onCleared)
     * to prevent coroutine and resource leaks.
     */
    public final void release() {
    }
    
    private final void initializeAudioEffects() {
    }
    
    private final void releaseAudioEffects() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/livegemini/audio/AudioHandler$Companion;", "", "()V", "AUDIO_FORMAT", "", "CHANNEL_CONFIG", "SAMPLE_RATE", "TAG", "", "livegeminiapi_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}