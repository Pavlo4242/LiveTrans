// Generated by data binding compiler. Do not edit!
package com.livegemini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.livegemini.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogUserSettingsBinding extends ViewDataBinding {
  @NonNull
  public final SwitchMaterial autoPlaybackSwitch;

  @NonNull
  public final ImageView closeBtn;

  @NonNull
  public final Button requestPermissionBtn;

  @NonNull
  public final TextView sendFeedbackBtn;

  @NonNull
  public final SeekBar textSizeSeekBar;

  protected DialogUserSettingsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      SwitchMaterial autoPlaybackSwitch, ImageView closeBtn, Button requestPermissionBtn,
      TextView sendFeedbackBtn, SeekBar textSizeSeekBar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.autoPlaybackSwitch = autoPlaybackSwitch;
    this.closeBtn = closeBtn;
    this.requestPermissionBtn = requestPermissionBtn;
    this.sendFeedbackBtn = sendFeedbackBtn;
    this.textSizeSeekBar = textSizeSeekBar;
  }

  @NonNull
  public static DialogUserSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_user_settings, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogUserSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogUserSettingsBinding>inflateInternal(inflater, R.layout.dialog_user_settings, root, attachToRoot, component);
  }

  @NonNull
  public static DialogUserSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_user_settings, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogUserSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogUserSettingsBinding>inflateInternal(inflater, R.layout.dialog_user_settings, null, false, component);
  }

  public static DialogUserSettingsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static DialogUserSettingsBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogUserSettingsBinding)bind(component, view, R.layout.dialog_user_settings);
  }
}
