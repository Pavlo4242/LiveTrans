package com.data;

/**
 * A repository to abstract access to SharedPreferences for app settings.
 * This makes the ViewModel more testable and separates data access logic.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/data/SettingsRepository;", "", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getApiHost", "", "getApiKey", "getApiVersion", "getSelectedModel", "getSessionHandle", "getShowDebugOverlay", "", "getVadSensitivity", "", "getWebSocketConfig", "Lcom/network/WebSocketClient$WebSocketConfig;", "sessionHandle", "saveSessionHandle", "", "handle", "setApiHost", "host", "setApiKey", "key", "setApiVersion", "version", "setSelectedModel", "model", "setShowDebugOverlay", "enabled", "setVadSensitivity", "value", "livegeminiapi_debug"})
public final class SettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    
    public SettingsRepository(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApiHost() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedModel() {
        return null;
    }
    
    public final int getVadSensitivity() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApiVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSessionHandle() {
        return null;
    }
    
    public final boolean getShowDebugOverlay() {
        return false;
    }
    
    public final void saveSessionHandle(@org.jetbrains.annotations.Nullable()
    java.lang.String handle) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.network.WebSocketClient.WebSocketConfig getWebSocketConfig(@org.jetbrains.annotations.Nullable()
    java.lang.String sessionHandle) {
        return null;
    }
    
    public final void setShowDebugOverlay(boolean enabled) {
    }
    
    public final void setVadSensitivity(int value) {
    }
    
    public final void setApiHost(@org.jetbrains.annotations.NotNull()
    java.lang.String host) {
    }
    
    public final void setSelectedModel(@org.jetbrains.annotations.NotNull()
    java.lang.String model) {
    }
    
    public final void setApiVersion(@org.jetbrains.annotations.NotNull()
    java.lang.String version) {
    }
    
    public final void setApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
}