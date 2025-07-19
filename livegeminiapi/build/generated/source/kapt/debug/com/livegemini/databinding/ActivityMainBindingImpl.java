package com.livegemini.databinding;
import com.livegemini.R;
import com.livegemini.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 1);
        sViewsWithIds.put(R.id.topAppBar, 2);
        sViewsWithIds.put(R.id.toolbarInfoText, 3);
        sViewsWithIds.put(R.id.historyBtn, 4);
        sViewsWithIds.put(R.id.settingsBtn, 5);
        sViewsWithIds.put(R.id.debugOverlayScroll, 6);
        sViewsWithIds.put(R.id.debugOverlayText, 7);
        sViewsWithIds.put(R.id.infoText, 8);
        sViewsWithIds.put(R.id.transcriptLog, 9);
        sViewsWithIds.put(R.id.micBtn, 10);
        sViewsWithIds.put(R.id.statusText, 11);
        sViewsWithIds.put(R.id.debugSettingsBtn, 12);
        sViewsWithIds.put(R.id.connectDisconnectBtn, 13);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[1]
            , (android.widget.Button) bindings[13]
            , (android.widget.ScrollView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.Button) bindings[12]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[10]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[2]
            , (androidx.compose.ui.platform.ComposeView) bindings[9]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}