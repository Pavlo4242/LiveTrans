package com.livegemini;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.livegemini.databinding.ActivityMainBindingImpl;
import com.livegemini.databinding.DialogSettingsBindingImpl;
import com.livegemini.databinding.DialogUserSettingsBindingImpl;
import com.livegemini.databinding.ItemTranslationBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_DIALOGSETTINGS = 2;

  private static final int LAYOUT_DIALOGUSERSETTINGS = 3;

  private static final int LAYOUT_ITEMTRANSLATION = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.livegemini.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.livegemini.R.layout.dialog_settings, LAYOUT_DIALOGSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.livegemini.R.layout.dialog_user_settings, LAYOUT_DIALOGUSERSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.livegemini.R.layout.item_translation, LAYOUT_ITEMTRANSLATION);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGSETTINGS: {
          if ("layout/dialog_settings_0".equals(tag)) {
            return new DialogSettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_settings is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGUSERSETTINGS: {
          if ("layout/dialog_user_settings_0".equals(tag)) {
            return new DialogUserSettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_user_settings is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMTRANSLATION: {
          if ("layout/item_translation_0".equals(tag)) {
            return new ItemTranslationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_translation is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_main_0", com.livegemini.R.layout.activity_main);
      sKeys.put("layout/dialog_settings_0", com.livegemini.R.layout.dialog_settings);
      sKeys.put("layout/dialog_user_settings_0", com.livegemini.R.layout.dialog_user_settings);
      sKeys.put("layout/item_translation_0", com.livegemini.R.layout.item_translation);
    }
  }
}
