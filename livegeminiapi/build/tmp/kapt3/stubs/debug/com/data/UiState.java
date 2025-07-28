package com.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003Js\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/data/UiState;", "", "connectionState", "Lcom/data/ConnectionState;", "toolbarInfoText", "", "isListening", "", "statusText", "translations", "", "Lcom/data/TranslationItem;", "isMicButtonEnabled", "showDebugOverlay", "debugLog", "showUserSettingsDialog", "showDebugSettingsDialog", "(Lcom/data/ConnectionState;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;ZZLjava/lang/String;ZZ)V", "getConnectionState", "()Lcom/data/ConnectionState;", "getDebugLog", "()Ljava/lang/String;", "()Z", "isSessionActive", "getShowDebugOverlay", "getShowDebugSettingsDialog", "getShowUserSettingsDialog", "getStatusText", "getToolbarInfoText", "getTranslations", "()Ljava/util/List;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "livegeminiapi_debug"})
public final class UiState {
    @org.jetbrains.annotations.NotNull()
    private final com.data.ConnectionState connectionState = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String toolbarInfoText = null;
    private final boolean isListening = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusText = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.data.TranslationItem> translations = null;
    private final boolean isMicButtonEnabled = false;
    private final boolean showDebugOverlay = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String debugLog = null;
    private final boolean showUserSettingsDialog = false;
    private final boolean showDebugSettingsDialog = false;
    
    public UiState(@org.jetbrains.annotations.NotNull()
    com.data.ConnectionState connectionState, @org.jetbrains.annotations.NotNull()
    java.lang.String toolbarInfoText, boolean isListening, @org.jetbrains.annotations.NotNull()
    java.lang.String statusText, @org.jetbrains.annotations.NotNull()
    java.util.List<com.data.TranslationItem> translations, boolean isMicButtonEnabled, boolean showDebugOverlay, @org.jetbrains.annotations.NotNull()
    java.lang.String debugLog, boolean showUserSettingsDialog, boolean showDebugSettingsDialog) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.data.ConnectionState getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToolbarInfoText() {
        return null;
    }
    
    public final boolean isListening() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatusText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.data.TranslationItem> getTranslations() {
        return null;
    }
    
    public final boolean isMicButtonEnabled() {
        return false;
    }
    
    public final boolean getShowDebugOverlay() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDebugLog() {
        return null;
    }
    
    public final boolean getShowUserSettingsDialog() {
        return false;
    }
    
    public final boolean getShowDebugSettingsDialog() {
        return false;
    }
    
    public final boolean isSessionActive() {
        return false;
    }
    
    public UiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.data.ConnectionState component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.data.TranslationItem> component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.data.UiState copy(@org.jetbrains.annotations.NotNull()
    com.data.ConnectionState connectionState, @org.jetbrains.annotations.NotNull()
    java.lang.String toolbarInfoText, boolean isListening, @org.jetbrains.annotations.NotNull()
    java.lang.String statusText, @org.jetbrains.annotations.NotNull()
    java.util.List<com.data.TranslationItem> translations, boolean isMicButtonEnabled, boolean showDebugOverlay, @org.jetbrains.annotations.NotNull()
    java.lang.String debugLog, boolean showUserSettingsDialog, boolean showDebugSettingsDialog) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}