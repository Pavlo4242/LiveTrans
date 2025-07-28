package com.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 S2\u00020\u0001:\u0003STUB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000206H\u0002J\u0012\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020/H\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u001aH\u0002J\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020/H\u0002J\b\u0010@\u001a\u00020/H\u0002J\b\u0010A\u001a\u00020/H\u0002J\u0010\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u00020/H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020/H\u0014J\u0010\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020$H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020/H\u0002J\b\u0010N\u001a\u00020/H\u0002J\b\u0010O\u001a\u00020/H\u0002J\u0018\u0010P\u001a\u00020/2\u0006\u0010I\u001a\u00020$2\u0006\u0010Q\u001a\u00020\u001aH\u0002J\b\u0010R\u001a\u00020/H\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0012\u0010)\u001a\u00060\u001dj\u0002`\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006V"}, d2 = {"Lcom/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "audioHandler", "Lcom/livegemini/audio/AudioHandler;", "webSocketFactory", "Lcom/network/WebSocketClient$Companion;", "settingsRepository", "Lcom/data/SettingsRepository;", "appLogger", "Lcom/utils/AppLogger;", "(Landroid/app/Application;Lcom/livegemini/audio/AudioHandler;Lcom/network/WebSocketClient$Companion;Lcom/data/SettingsRepository;Lcom/utils/AppLogger;)V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/viewmodel/MainViewModel$ViewEvent;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/data/UiState;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "gson", "Lcom/google/gson/Gson;", "lastSpeakerIsUser", "", "Ljava/lang/Boolean;", "modelTranslationBuffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "reconnectAttempts", "", "reconnectJob", "Lkotlinx/coroutines/Job;", "sessionHandle", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "userInputBuffer", "webSocketClient", "Lcom/network/WebSocketClient;", "webSocketListener", "Lcom/network/WebSocketClient$WebSocketListener;", "cleanupConnection", "", "clearDebugLog", "commitAndResetBuffers", "connect", "createDebugLogFile", "Landroid/net/Uri;", "createWebSocketConfig", "Lcom/network/WebSocketClient$WebSocketConfig;", "disconnect", "reconnect", "handleClearDebugLog", "handleConnectionToggle", "force", "handleEvent", "event", "Lcom/viewmodel/MainViewModel$UserEvent;", "handleForceReconnect", "handleShareDebugLog", "handleShareLog", "handleToggleDebugOverlay", "enabled", "loadConfiguration", "logDebug", "message", "onCleared", "processServerMessage", "text", "processTranscription", "response", "Lcom/data/ServerResponse;", "reloadConfiguration", "scheduleReconnect", "toggleRecording", "updateOrAddTranslation", "isUser", "updateToolbarText", "Companion", "UserEvent", "ViewEvent", "livegeminiapi_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application application = null;
    @org.jetbrains.annotations.NotNull()
    private final com.livegemini.audio.AudioHandler audioHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final com.network.WebSocketClient.Companion webSocketFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final com.data.SettingsRepository settingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.utils.AppLogger appLogger = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.data.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.data.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.viewmodel.MainViewModel.ViewEvent> _events = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.viewmodel.MainViewModel.ViewEvent> events = null;
    @org.jetbrains.annotations.Nullable()
    private com.network.WebSocketClient webSocketClient;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job reconnectJob;
    private int reconnectAttempts = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.StringBuilder userInputBuffer = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.StringBuilder modelTranslationBuffer = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean lastSpeakerIsUser;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String sessionHandle;
    @org.jetbrains.annotations.NotNull()
    private final com.network.WebSocketClient.WebSocketListener webSocketListener = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MainViewModel";
    private static final int MAX_RECONNECT_ATTEMPTS = 5;
    @org.jetbrains.annotations.NotNull()
    public static final com.viewmodel.MainViewModel.Companion Companion = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.livegemini.audio.AudioHandler audioHandler, @org.jetbrains.annotations.NotNull()
    com.network.WebSocketClient.Companion webSocketFactory, @org.jetbrains.annotations.NotNull()
    com.data.SettingsRepository settingsRepository, @org.jetbrains.annotations.NotNull()
    com.utils.AppLogger appLogger) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.data.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.viewmodel.MainViewModel.ViewEvent> getEvents() {
        return null;
    }
    
    public final void handleEvent(@org.jetbrains.annotations.NotNull()
    com.viewmodel.MainViewModel.UserEvent event) {
    }
    
    private final void connect() {
    }
    
    private final com.network.WebSocketClient.WebSocketConfig createWebSocketConfig() {
        return null;
    }
    
    private final void handleConnectionToggle(boolean force) {
    }
    
    private final void disconnect(boolean reconnect) {
    }
    
    private final void processServerMessage(java.lang.String text) {
    }
    
    private final void processTranscription(com.data.ServerResponse response) {
    }
    
    private final void toggleRecording() {
    }
    
    private final void updateOrAddTranslation(java.lang.String text, boolean isUser) {
    }
    
    private final void commitAndResetBuffers() {
    }
    
    private final void scheduleReconnect() {
    }
    
    private final void loadConfiguration() {
    }
    
    private final void reloadConfiguration() {
    }
    
    private final void updateToolbarText() {
    }
    
    private final void handleShareLog() {
    }
    
    private final void clearDebugLog() {
    }
    
    private final void handleForceReconnect() {
    }
    
    private final void handleClearDebugLog() {
    }
    
    private final void handleShareDebugLog() {
    }
    
    private final android.net.Uri createDebugLogFile() {
        return null;
    }
    
    private final void handleToggleDebugOverlay(boolean enabled) {
    }
    
    private final void logDebug(java.lang.String message) {
    }
    
    private final void cleanupConnection() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/viewmodel/MainViewModel$Companion;", "", "()V", "MAX_RECONNECT_ATTEMPTS", "", "TAG", "", "livegeminiapi_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\r\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent;", "", "()V", "ClearDebugLog", "ClearLogRequested", "ConnectToggleClicked", "DebugSettingsClicked", "DismissDebugSettings", "DismissUserSettings", "ForceReconnect", "MicClicked", "SettingsSaved", "ShareDebugLog", "ShareLogRequested", "ToggleDebugOverlay", "UserSettingsClicked", "Lcom/viewmodel/MainViewModel$UserEvent$ClearDebugLog;", "Lcom/viewmodel/MainViewModel$UserEvent$ClearLogRequested;", "Lcom/viewmodel/MainViewModel$UserEvent$ConnectToggleClicked;", "Lcom/viewmodel/MainViewModel$UserEvent$DebugSettingsClicked;", "Lcom/viewmodel/MainViewModel$UserEvent$DismissDebugSettings;", "Lcom/viewmodel/MainViewModel$UserEvent$DismissUserSettings;", "Lcom/viewmodel/MainViewModel$UserEvent$ForceReconnect;", "Lcom/viewmodel/MainViewModel$UserEvent$MicClicked;", "Lcom/viewmodel/MainViewModel$UserEvent$SettingsSaved;", "Lcom/viewmodel/MainViewModel$UserEvent$ShareDebugLog;", "Lcom/viewmodel/MainViewModel$UserEvent$ShareLogRequested;", "Lcom/viewmodel/MainViewModel$UserEvent$ToggleDebugOverlay;", "Lcom/viewmodel/MainViewModel$UserEvent$UserSettingsClicked;", "livegeminiapi_debug"})
    public static abstract class UserEvent {
        
        private UserEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ClearDebugLog;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ClearDebugLog extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.ClearDebugLog INSTANCE = null;
            
            private ClearDebugLog() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ClearLogRequested;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ClearLogRequested extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.ClearLogRequested INSTANCE = null;
            
            private ClearLogRequested() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ConnectToggleClicked;", "Lcom/viewmodel/MainViewModel$UserEvent;", "force", "", "(Z)V", "getForce", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livegeminiapi_debug"})
        public static final class ConnectToggleClicked extends com.viewmodel.MainViewModel.UserEvent {
            private final boolean force = false;
            
            public ConnectToggleClicked(boolean force) {
            }
            
            public final boolean getForce() {
                return false;
            }
            
            public ConnectToggleClicked() {
            }
            
            public final boolean component1() {
                return false;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.viewmodel.MainViewModel.UserEvent.ConnectToggleClicked copy(boolean force) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$DebugSettingsClicked;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class DebugSettingsClicked extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.DebugSettingsClicked INSTANCE = null;
            
            private DebugSettingsClicked() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$DismissDebugSettings;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class DismissDebugSettings extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.DismissDebugSettings INSTANCE = null;
            
            private DismissDebugSettings() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$DismissUserSettings;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class DismissUserSettings extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.DismissUserSettings INSTANCE = null;
            
            private DismissUserSettings() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ForceReconnect;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ForceReconnect extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.ForceReconnect INSTANCE = null;
            
            private ForceReconnect() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$MicClicked;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class MicClicked extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.MicClicked INSTANCE = null;
            
            private MicClicked() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$SettingsSaved;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class SettingsSaved extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.SettingsSaved INSTANCE = null;
            
            private SettingsSaved() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ShareDebugLog;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ShareDebugLog extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.ShareDebugLog INSTANCE = null;
            
            private ShareDebugLog() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ShareLogRequested;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ShareLogRequested extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.ShareLogRequested INSTANCE = null;
            
            private ShareLogRequested() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$ToggleDebugOverlay;", "Lcom/viewmodel/MainViewModel$UserEvent;", "enabled", "", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livegeminiapi_debug"})
        public static final class ToggleDebugOverlay extends com.viewmodel.MainViewModel.UserEvent {
            private final boolean enabled = false;
            
            public ToggleDebugOverlay(boolean enabled) {
            }
            
            public final boolean getEnabled() {
                return false;
            }
            
            public final boolean component1() {
                return false;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.viewmodel.MainViewModel.UserEvent.ToggleDebugOverlay copy(boolean enabled) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/viewmodel/MainViewModel$UserEvent$UserSettingsClicked;", "Lcom/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class UserSettingsClicked extends com.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.viewmodel.MainViewModel.UserEvent.UserSettingsClicked INSTANCE = null;
            
            private UserSettingsClicked() {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/viewmodel/MainViewModel$ViewEvent;", "", "()V", "ShareDebugLogFile", "ShareLogFile", "ShowError", "ShowToast", "Lcom/viewmodel/MainViewModel$ViewEvent$ShareDebugLogFile;", "Lcom/viewmodel/MainViewModel$ViewEvent$ShareLogFile;", "Lcom/viewmodel/MainViewModel$ViewEvent$ShowError;", "Lcom/viewmodel/MainViewModel$ViewEvent$ShowToast;", "livegeminiapi_debug"})
    public static abstract class ViewEvent {
        
        private ViewEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/viewmodel/MainViewModel$ViewEvent$ShareDebugLogFile;", "Lcom/viewmodel/MainViewModel$ViewEvent;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livegeminiapi_debug"})
        public static final class ShareDebugLogFile extends com.viewmodel.MainViewModel.ViewEvent {
            @org.jetbrains.annotations.NotNull()
            private final android.net.Uri uri = null;
            
            public ShareDebugLogFile(@org.jetbrains.annotations.NotNull()
            android.net.Uri uri) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.net.Uri getUri() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.net.Uri component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.viewmodel.MainViewModel.ViewEvent.ShareDebugLogFile copy(@org.jetbrains.annotations.NotNull()
            android.net.Uri uri) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/viewmodel/MainViewModel$ViewEvent$ShareLogFile;", "Lcom/viewmodel/MainViewModel$ViewEvent;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livegeminiapi_debug"})
        public static final class ShareLogFile extends com.viewmodel.MainViewModel.ViewEvent {
            @org.jetbrains.annotations.NotNull()
            private final android.net.Uri uri = null;
            
            public ShareLogFile(@org.jetbrains.annotations.NotNull()
            android.net.Uri uri) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.net.Uri getUri() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.net.Uri component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.viewmodel.MainViewModel.ViewEvent.ShareLogFile copy(@org.jetbrains.annotations.NotNull()
            android.net.Uri uri) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/viewmodel/MainViewModel$ViewEvent$ShowError;", "Lcom/viewmodel/MainViewModel$ViewEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livegeminiapi_debug"})
        public static final class ShowError extends com.viewmodel.MainViewModel.ViewEvent {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public ShowError(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.viewmodel.MainViewModel.ViewEvent.ShowError copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/viewmodel/MainViewModel$ViewEvent$ShowToast;", "Lcom/viewmodel/MainViewModel$ViewEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livegeminiapi_debug"})
        public static final class ShowToast extends com.viewmodel.MainViewModel.ViewEvent {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public ShowToast(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.viewmodel.MainViewModel.ViewEvent.ShowToast copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
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
    }
}