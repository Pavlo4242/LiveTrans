// Generated by data binding compiler. Do not edit!
package com.livegemini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livegemini.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemTranslationBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout messageContainer;

  @NonNull
  public final TextView speakerLabel;

  @NonNull
  public final TextView translationText;

  protected ItemTranslationBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout messageContainer, TextView speakerLabel, TextView translationText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.messageContainer = messageContainer;
    this.speakerLabel = speakerLabel;
    this.translationText = translationText;
  }

  @NonNull
  public static ItemTranslationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_translation, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemTranslationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemTranslationBinding>inflateInternal(inflater, R.layout.item_translation, root, attachToRoot, component);
  }

  @NonNull
  public static ItemTranslationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_translation, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemTranslationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemTranslationBinding>inflateInternal(inflater, R.layout.item_translation, null, false, component);
  }

  public static ItemTranslationBinding bind(@NonNull View view) {
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
  public static ItemTranslationBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemTranslationBinding)bind(component, view, R.layout.item_translation);
  }
}
