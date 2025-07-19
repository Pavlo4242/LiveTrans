package com.ui.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/ui/dialog/SettingsDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "listener", "Lcom/ui/dialog/SettingsDialog$DevSettingsListener;", "prefs", "Landroid/content/SharedPreferences;", "models", "", "", "(Landroid/content/Context;Lcom/ui/dialog/SettingsDialog$DevSettingsListener;Landroid/content/SharedPreferences;Ljava/util/List;)V", "apiKeysList", "Lcom/livegemini/data/ApiKeyInfo;", "apiVersionsList", "Lcom/livegemini/data/ApiVersion;", "binding", "Lcom/livegemini/databinding/DialogSettingsBinding;", "selectedApiKeyInfo", "selectedApiVersion", "selectedModel", "loadAndSetCurrentValues", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveSettings", "setupViews", "Companion", "DevSettingsListener", "livegeminiapi_debug"})
public final class SettingsDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private final com.ui.dialog.SettingsDialog.DevSettingsListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> models = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SettingsDialog";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_API_HOST = "generativelanguage.googleapis.com";
    private com.livegemini.databinding.DialogSettingsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.livegemini.data.ApiVersion> apiVersionsList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.livegemini.data.ApiKeyInfo> apiKeysList;
    @org.jetbrains.annotations.Nullable()
    private com.livegemini.data.ApiVersion selectedApiVersion;
    @org.jetbrains.annotations.Nullable()
    private com.livegemini.data.ApiKeyInfo selectedApiKeyInfo;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedModel;
    @org.jetbrains.annotations.NotNull()
    public static final com.ui.dialog.SettingsDialog.Companion Companion = null;
    
    public SettingsDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.ui.dialog.SettingsDialog.DevSettingsListener listener, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> models) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadAndSetCurrentValues() {
    }
    
    private final void setupViews() {
    }
    
    private final void saveSettings() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/ui/dialog/SettingsDialog$Companion;", "", "()V", "DEFAULT_API_HOST", "", "TAG", "livegeminiapi_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/ui/dialog/SettingsDialog$DevSettingsListener;", "", "onClearLog", "", "onForceConnect", "onSettingsSaved", "onShareLog", "livegeminiapi_debug"})
    public static abstract interface DevSettingsListener {
        
        public abstract void onForceConnect();
        
        public abstract void onSettingsSaved();
        
        public abstract void onShareLog();
        
        public abstract void onClearLog();
    }
}