package com.livegemini.databinding;
import com.livegemini.R;
import com.livegemini.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogSettingsBindingImpl extends DialogSettingsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.hostManualEditText, 1);
        sViewsWithIds.put(R.id.apiVersionRadioGroup, 2);
        sViewsWithIds.put(R.id.apiKeyRadioGroup, 3);
        sViewsWithIds.put(R.id.apiKeyManualEditText, 4);
        sViewsWithIds.put(R.id.modelRadioGroup, 5);
        sViewsWithIds.put(R.id.modelManualEditText, 6);
        sViewsWithIds.put(R.id.vadSensitivity, 7);
        sViewsWithIds.put(R.id.vadValue, 8);
        sViewsWithIds.put(R.id.debugOverlaySwitch, 9);
        sViewsWithIds.put(R.id.shareLogBtn, 10);
        sViewsWithIds.put(R.id.clearLogBtn, 11);
        sViewsWithIds.put(R.id.forceConnectBtn, 12);
        sViewsWithIds.put(R.id.saveSettingsBtn, 13);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogSettingsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private DialogSettingsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (android.widget.RadioGroup) bindings[3]
            , (android.widget.RadioGroup) bindings[2]
            , (android.widget.Button) bindings[11]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[9]
            , (android.widget.Button) bindings[12]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (android.widget.RadioGroup) bindings[5]
            , (android.widget.Button) bindings[13]
            , (android.widget.Button) bindings[10]
            , (android.widget.SeekBar) bindings[7]
            , (android.widget.TextView) bindings[8]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
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