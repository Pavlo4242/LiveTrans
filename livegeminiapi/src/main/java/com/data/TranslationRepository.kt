package com.data

import android.content.SharedPreferences
import android.content.res.Resources
import com.livegemini.R
import com.data.models.ApiVersion

class TranslationRepository(
    private val prefs: SharedPreferences,
    private val resources: Resources
    private val prefs: SharedPreferences,
    private val resources: Resources
) {
    fun getSelectedModel(): String = prefs.getString("selected_model", "") ?: ""

    fun getApiVersions(): List<ApiVersion> {
        return resources.getStringArray(R.array.api_versions).mapNotNull {
            val parts = it.split("|", limit = 2)
            if (parts.size == 2) ApiVersion(parts[0].trim(), parts[1].trim())
            else null
        }
    }


}