package com.livegemini.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 X2\u00020\u0001:\u0003XYZB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u000200H\u0002J\b\u00103\u001a\u000200H\u0002J\b\u00104\u001a\u000200H\u0002J\u000e\u00105\u001a\u0002002\u0006\u00106\u001a\u000207J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\u0018\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u001a\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010B\u001a\u000200H\u0002J\b\u0010C\u001a\u000200H\u0002J\u0010\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\u001dH\u0002J\b\u0010F\u001a\u000200H\u0014J\u000e\u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020\u0016J\u0010\u0010I\u001a\u0002002\u0006\u0010@\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\u001dH\u0002J\u0010\u0010M\u001a\u0002002\u0006\u0010@\u001a\u00020JH\u0002J\u0010\u0010N\u001a\u0002002\u0006\u0010@\u001a\u00020JH\u0002J\b\u0010O\u001a\u000200H\u0002J\b\u0010P\u001a\u000200H\u0002J\b\u0010Q\u001a\u000200H\u0002J\b\u0010R\u001a\u000200H\u0002J\b\u0010S\u001a\u000200H\u0002J\b\u0010T\u001a\u000200H\u0002J\b\u0010U\u001a\u000200H\u0002J\u0018\u0010V\u001a\u0002002\u0006\u0010L\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\u0016H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n  *\u0004\u0018\u00010&0&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00060\u0019j\u0002`\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "audioHandler", "Lcom/livegemini/audio/AudioHandler;", "webSocketFactory", "Lcom/livegemini/network/WebSocketClient$Companion;", "(Landroid/app/Application;Lcom/livegemini/audio/AudioHandler;Lcom/livegemini/network/WebSocketClient$Companion;)V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/livegemini/data/UiState;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "gson", "Lcom/google/gson/Gson;", "lastSpeakerIsUser", "", "Ljava/lang/Boolean;", "modelTranslationBuffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "models", "", "", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "reconnectAttempts", "", "reconnectJob", "Lkotlinx/coroutines/Job;", "resources", "Landroid/content/res/Resources;", "sessionHandle", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "userInputBuffer", "webSocketClient", "Lcom/livegemini/network/WebSocketClient;", "checkAudioPermission", "", "cleanupConnection", "clearDebugLog", "connect", "disconnect", "handleEvent", "event", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "handleSetupComplete", "handleShareLog", "handleWebSocketClosing", "code", "reason", "handleWebSocketFailure", "t", "", "response", "Lokhttp3/Response;", "handleWebSocketOpen", "loadConfiguration", "logDebug", "message", "onCleared", "onPermissionResult", "granted", "processAudioOutput", "Lcom/livegemini/data/ServerResponse;", "processServerMessage", "text", "processTranscription", "processTurnCompletion", "reloadConfiguration", "scheduleReconnect", "startRecording", "stopRecording", "toggleConnection", "toggleRecording", "updateToolbarText", "updateTranslation", "isUser", "Companion", "UserEvent", "ViewEvent", "livegeminiapi_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application application = null;
    @org.jetbrains.annotations.NotNull()
    private final com.livegemini.audio.AudioHandler audioHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final com.livegemini.network.WebSocketClient.Companion webSocketFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.livegemini.data.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.livegemini.data.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.livegemini.viewmodel.MainViewModel.ViewEvent> _events = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.livegemini.viewmodel.MainViewModel.ViewEvent> events = null;
    private final android.content.SharedPreferences prefs = null;
    private final android.content.res.Resources resources = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> models = null;
    @org.jetbrains.annotations.Nullable()
    private com.livegemini.network.WebSocketClient webSocketClient;
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
    private static final java.lang.String TAG = "MainViewModel";
    private static final int MAX_RECONNECT_ATTEMPTS = 5;
    @org.jetbrains.annotations.NotNull()
    public static final com.livegemini.viewmodel.MainViewModel.Companion Companion = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.livegemini.audio.AudioHandler audioHandler, @org.jetbrains.annotations.NotNull()
    com.livegemini.network.WebSocketClient.Companion webSocketFactory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.livegemini.data.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.livegemini.viewmodel.MainViewModel.ViewEvent> getEvents() {
        return null;
    }
    
    public final void handleEvent(@org.jetbrains.annotations.NotNull()
    com.livegemini.viewmodel.MainViewModel.UserEvent event) {
    }
    
    public final void onPermissionResult(boolean granted) {
    }
    
    private final void toggleRecording() {
    }
    
    private final void toggleConnection() {
    }
    
    private final void connect() {
    }
    
    private final void disconnect() {
    }
    
    private final void startRecording() {
    }
    
    private final void stopRecording() {
    }
    
    private final void handleWebSocketOpen() {
    }
    
    private final void handleSetupComplete() {
    }
    
    private final void handleWebSocketClosing(int code, java.lang.String reason) {
    }
    
    private final void handleWebSocketFailure(java.lang.Throwable t, okhttp3.Response response) {
    }
    
    private final void processServerMessage(java.lang.String text) {
    }
    
    private final void processTranscription(com.livegemini.data.ServerResponse response) {
    }
    
    private final void processAudioOutput(com.livegemini.data.ServerResponse response) {
    }
    
    private final void processTurnCompletion(com.livegemini.data.ServerResponse response) {
    }
    
    private final void scheduleReconnect() {
    }
    
    private final void updateTranslation(java.lang.String text, boolean isUser) {
    }
    
    private final void loadConfiguration() {
    }
    
    private final void reloadConfiguration() {
    }
    
    private final void updateToolbarText() {
    }
    
    private final void checkAudioPermission() {
    }
    
    private final void handleShareLog() {
    }
    
    private final void clearDebugLog() {
    }
    
    private final void logDebug(java.lang.String message) {
    }
    
    private final void cleanupConnection() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$Companion;", "", "()V", "MAX_RECONNECT_ATTEMPTS", "", "TAG", "", "livegeminiapi_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "", "()V", "ClearLogRequested", "ConnectClicked", "MicClicked", "RequestPermission", "SettingsSaved", "ShareLogRequested", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent$ClearLogRequested;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent$ConnectClicked;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent$MicClicked;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent$RequestPermission;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent$SettingsSaved;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent$ShareLogRequested;", "livegeminiapi_debug"})
    public static abstract class UserEvent {
        
        private UserEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent$ClearLogRequested;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ClearLogRequested extends com.livegemini.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.livegemini.viewmodel.MainViewModel.UserEvent.ClearLogRequested INSTANCE = null;
            
            private ClearLogRequested() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent$ConnectClicked;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ConnectClicked extends com.livegemini.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.livegemini.viewmodel.MainViewModel.UserEvent.ConnectClicked INSTANCE = null;
            
            private ConnectClicked() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent$MicClicked;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class MicClicked extends com.livegemini.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.livegemini.viewmodel.MainViewModel.UserEvent.MicClicked INSTANCE = null;
            
            private MicClicked() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent$RequestPermission;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class RequestPermission extends com.livegemini.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.livegemini.viewmodel.MainViewModel.UserEvent.RequestPermission INSTANCE = null;
            
            private RequestPermission() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent$SettingsSaved;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class SettingsSaved extends com.livegemini.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.livegemini.viewmodel.MainViewModel.UserEvent.SettingsSaved INSTANCE = null;
            
            private SettingsSaved() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$UserEvent$ShareLogRequested;", "Lcom/livegemini/viewmodel/MainViewModel$UserEvent;", "()V", "livegeminiapi_debug"})
        public static final class ShareLogRequested extends com.livegemini.viewmodel.MainViewModel.UserEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.livegemini.viewmodel.MainViewModel.UserEvent.ShareLogRequested INSTANCE = null;
            
            private ShareLogRequested() {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$ViewEvent;", "", "()V", "ShareLogFile", "ShowError", "ShowToast", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent$ShareLogFile;", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent$ShowError;", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent$ShowToast;", "livegeminiapi_debug"})
    public static abstract class ViewEvent {
        
        private ViewEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$ViewEvent$ShareLogFile;", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livegeminiapi_debug"})
        public static final class ShareLogFile extends com.livegemini.viewmodel.MainViewModel.ViewEvent {
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
            public final com.livegemini.viewmodel.MainViewModel.ViewEvent.ShareLogFile copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$ViewEvent$ShowError;", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livegeminiapi_debug"})
        public static final class ShowError extends com.livegemini.viewmodel.MainViewModel.ViewEvent {
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
            public final com.livegemini.viewmodel.MainViewModel.ViewEvent.ShowError copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/livegemini/viewmodel/MainViewModel$ViewEvent$ShowToast;", "Lcom/livegemini/viewmodel/MainViewModel$ViewEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livegeminiapi_debug"})
        public static final class ShowToast extends com.livegemini.viewmodel.MainViewModel.ViewEvent {
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
            public final com.livegemini.viewmodel.MainViewModel.ViewEvent.ShowToast copy(@org.jetbrains.annotations.NotNull()
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