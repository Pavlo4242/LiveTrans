package com.bwctrans.ui

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Toast
import com.bwctrans.R
import com.bwctrans.data.ApiKeyInfo
import com.bwctrans.data.ApiVersion
import com.bwctrans.databinding.DialogSettingsBinding

class SettingsDialog(
    context: Context,
    private val listener: DevSettingsListener,
    private val prefs: SharedPreferences,
    private val models: List<String>
) : Dialog(context) {

    // --- INTERFACE ---
    interface DevSettingsListener {
        fun onForceConnect()
        fun onSettingsSaved()
        fun onShareLog()
        fun onClearLog()
    }

    // --- PROPERTIES ---
    companion object { private const val TAG = "SettingsDialog" }
    private lateinit var binding: DialogSettingsBinding
    private var apiVersionsList: List<ApiVersion> = emptyList()
    private var apiKeysList: List<ApiKeyInfo> = emptyList()
    private var selectedApiVersion: ApiVersion? = null
    private var selectedApiKeyInfo: ApiKeyInfo? = null
    private var selectedModel: String = models.firstOrNull() ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(true)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        loadAndSetCurrentValues()
        setupViews()
    }

    private fun loadAndSetCurrentValues() {
        // API Versions
        val rawApiVersions = context.resources.getStringArray(R.array.api_versions)
        apiVersionsList = rawApiVersions.map {
            val parts = it.split("|", limit = 2)
            if (parts.size == 2) ApiVersion(parts[0].trim(), parts[1].trim())
            else ApiVersion(it.trim(), it.trim())
        }
        val currentApiVersionValue = prefs.getString("api_version", null)
        selectedApiVersion = apiVersionsList.firstOrNull { it.value == currentApiVersionValue } ?: apiVersionsList.firstOrNull()

        // API Keys
        val rawApiKeys = context.resources.getStringArray(R.array.api_keys)
        apiKeysList = rawApiKeys.mapNotNull {
            val parts = it.split(":", limit = 2)
            if (parts.size == 2) ApiKeyInfo(parts[0].trim(), parts[1].trim()) else null
        }
        val currentApiKeyValue = prefs.getString("api_key", null)
        selectedApiKeyInfo = apiKeysList.firstOrNull { it.value == currentApiKeyValue }

        // Model
        selectedModel = prefs.getString("selected_model", models.firstOrNull()) ?: ""
    }

    private fun setupViews() {
        // --- CONNECTION ---
        // FIX: Add a non-null default to prevent type mismatch
        binding.hostManualEditText.setText(prefs.getString("api_host", "generativelanguage.googleapis.com") ?: "generativelanguage.googleapis.com")

        apiVersionsList.forEach { apiVersion ->
            binding.apiVersionRadioGroup.addView(RadioButton(context).apply {
                text = apiVersion.displayName
                tag = apiVersion
                isChecked = apiVersion == selectedApiVersion
            })
        }
        binding.apiVersionRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedApiVersion = group.findViewById<RadioButton>(checkedId).tag as ApiVersion
        }

        // FIX: Add a non-null default to prevent type mismatch
        binding.apiKeyManualEditText.setText(prefs.getString("api_key", "") ?: "")
        apiKeysList.forEach { apiKey ->
            binding.apiKeyRadioGroup.addView(RadioButton(context).apply {
                text = apiKey.displayName
                tag = apiKey
                isChecked = apiKey.value == prefs.getString("api_key", null)
            })
        }
        binding.apiKeyRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val keyInfo = group.findViewById<RadioButton>(checkedId).tag as ApiKeyInfo
            binding.apiKeyManualEditText.setText(keyInfo.value)
        }

        // --- MODEL & BEHAVIOR ---
        binding.modelManualEditText.setText(selectedModel) // This one was already safe
        models.forEach { model ->
            binding.modelRadioGroup.addView(RadioButton(context).apply {
                text = model
                tag = model
                isChecked = model == selectedModel
            })
        }
        binding.modelRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val modelName = group.findViewById<RadioButton>(checkedId).tag.toString()
            binding.modelManualEditText.setText(modelName)
        }

        val currentVad = prefs.getInt("vad_sensitivity_ms", 800)
        binding.vadSensitivity.progress = currentVad
        binding.vadValue.text = "$currentVad ms"
        binding.vadSensitivity.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                binding.vadValue.text = "$progress ms"
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        // --- LOGGING ---
        binding.debugOverlaySwitch.isChecked = prefs.getBoolean("show_debug_overlay", false)
        binding.shareLogBtn.setOnClickListener {
            listener.onShareLog()
        }
        binding.clearLogBtn.setOnClickListener {
            listener.onClearLog()
            Toast.makeText(context, "On-screen log cleared", Toast.LENGTH_SHORT).show()
        }

        // --- ACTIONS ---
        binding.saveSettingsBtn.setOnClickListener {
            saveSettings()
            dismiss()
        }
        binding.forceConnectBtn.setOnClickListener {
            saveSettings()
            listener.onForceConnect()
            dismiss()
        }
    }

    private fun saveSettings() {
        prefs.edit().apply {
            putString("api_host", binding.hostManualEditText.text.toString().trim())
            putString("api_key", binding.apiKeyManualEditText.text.toString().trim())
            putString("selected_model", binding.modelManualEditText.text.toString().trim())
            selectedApiVersion?.let { putString("api_version", it.value) }
            putInt("vad_sensitivity_ms", binding.vadSensitivity.progress)
            putBoolean("show_debug_overlay", binding.debugOverlaySwitch.isChecked)
            apply()
        }
        Log.d(TAG, "Settings saved.")
        listener.onSettingsSaved()
    }
}
