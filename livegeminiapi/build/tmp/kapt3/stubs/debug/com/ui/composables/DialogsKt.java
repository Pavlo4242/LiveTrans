package com.ui.composables;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0012\u0010\u0006\u001a\u00020\u00012\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007\u001ap\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0016\u0010\u0012\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\b\u0010\u0013\u001a\u00020\u0001H\u0007\u00a8\u0006\u0014"}, d2 = {"DebugSettingsDialog", "", "viewModel", "Lcom/viewmodel/MainViewModel;", "onDismissRequest", "Lkotlin/Function0;", "DebugSettingsDialogPreview", "state", "Lcom/ui/composables/DebugSettingsState;", "DebugSettingsDialogStateless", "onToggleDebugOverlay", "Lkotlin/Function1;", "", "onForceReconnect", "onShareDebugLog", "onClearDebugLog", "modifier", "Landroidx/compose/ui/Modifier;", "UserSettingsDialog", "UserSettingsDialogPreview", "livegeminiapi_debug"})
public final class DialogsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void UserSettingsDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DebugSettingsDialogStateless(@org.jetbrains.annotations.NotNull()
    com.ui.composables.DebugSettingsState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDebugOverlay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onForceReconnect, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onShareDebugLog, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearDebugLog, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview()
    @androidx.compose.runtime.Composable()
    public static final void DebugSettingsDialogPreview(@androidx.compose.ui.tooling.preview.PreviewParameter(provider = com.ui.composables.DebugSettingsStateProvider.class)
    @org.jetbrains.annotations.NotNull()
    com.ui.composables.DebugSettingsState state) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DebugSettingsDialog(@org.jetbrains.annotations.NotNull()
    com.viewmodel.MainViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview()
    @androidx.compose.runtime.Composable()
    public static final void UserSettingsDialogPreview() {
    }
}