// app/src/main/java/com/bwctrans/MainActivity.kt
package com.bwctrans

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwctrans.databinding.ActivityMainBinding
import com.bwctrans.ui.SettingsDialog
import com.bwctrans.ui.TranslationAdapter
import com.bwctrans.ui.UserSettingsDialogFragment
import com.bwctrans.viewmodel.MainViewModel
import com.bwctrans.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SettingsDialog.DevSettingsListener, UserSettingsDialogFragment.UserSettingsListener {

    // ================ COMPANION OBJECT ================
    companion object {
        private const val TAG = "MainActivity"
    }

    // ================ UI ELEMENTS ================
    private lateinit var binding: ActivityMainBinding
    private lateinit var translationAdapter: TranslationAdapter

    // ================ VIEWMODEL ================
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(application)
    }

    // ================ PERMISSIONS ================
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        viewModel.onPermissionResult(isGranted)
    }

    // ================ LIFECYCLE METHODS ================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: Activity created.")

        setupUI()
        checkPermissions()
        observeViewModel()
    }

    // ================ UI SETUP ================
    private fun setupUI() {
        // Toolbar setup
        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // RecyclerView setup
        translationAdapter = TranslationAdapter()
        binding.transcriptLog.layoutManager = LinearLayoutManager(this).apply {
            reverseLayout = true
        }
        binding.transcriptLog.adapter = translationAdapter
        binding.transcriptLog.itemAnimator = null // Disable default animations for smoother updates

        // Button click listeners
        binding.settingsBtn.setOnClickListener {
            UserSettingsDialogFragment().show(supportFragmentManager, "UserSettingsDialog")
        }

        binding.debugSettingsBtn.setOnClickListener {
            val models = listOf(
                "gemini-2.5-flash-preview-native-audio-dialog",
                "gemini-2.0-flash-live-001",
                "gemini-2.5-flash-live-preview"
            )
            SettingsDialog(
                this,
                this,
                getSharedPreferences("BwctransPrefs", MODE_PRIVATE),
                models
            ).show()
        }

        binding.connectDisconnectBtn.setOnClickListener {
            viewModel.onConnectDisconnectClicked()
        }

        binding.micBtn.setOnClickListener {
            viewModel.onMicButtonClicked()
        }
    }

    // ================ VIEWMODEL OBSERVATION ================
    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Observe UI state
                launch {
                    viewModel.uiState.collect { state ->
                        updateUiFromState(state)
                    }
                }

                // Observe one-time events
                launch {
                    viewModel.events.collect { event ->
                        when (event) {
                            is MainViewModel.ViewEvent.ShowToast -> {
                                Toast.makeText(
                                    this@MainActivity,
                                    event.message,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            is MainViewModel.ViewEvent.ShareFile -> {
                                shareFile(event.fileUri, event.mimeType)
                            }
                        }
                    }
                }
            }
        }
    }

    // ================ UI STATE UPDATES ================
    private fun updateUiFromState(state: com.bwctrans.data.UiState) {
        // Basic UI updates
        binding.statusText.text = state.statusText
        binding.toolbarInfoText.text = state.toolbarInfoText
        binding.micBtn.setImageResource(if (state.isListening) R.drawable.ic_stop else R.drawable.ic_mic)
        binding.micBtn.isEnabled = state.isMicButtonEnabled
        binding.connectDisconnectBtn.text = if (state.isSessionActive) "Disconnect" else "Connect"
        binding.infoText.visibility = if (state.showInfoText) View.VISIBLE else View.GONE
        binding.debugOverlayScroll.visibility = if (state.showDebugOverlay) View.VISIBLE else View.GONE

        // Translation list updates
        translationAdapter.submitList(state.translations.reversed())
        if (state.translations.size > translationAdapter.currentList.size) {
            binding.transcriptLog.scrollToPosition(0)
        }

        // Debug overlay updates
        if (state.showDebugOverlay) {
            if (binding.debugOverlayText.text.length != state.debugLog.length) {
                binding.debugOverlayText.text = state.debugLog
                binding.debugOverlayScroll.post { 
                    binding.debugOverlayScroll.fullScroll(View.FOCUS_DOWN) 
                }
            }
        }
    }

    // ================ PERMISSION HANDLING ================
    private fun checkPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i(TAG, "RECORD_AUDIO permission already granted.")
                viewModel.onPermissionResult(true)
            }
            else -> {
                Log.i(TAG, "Requesting RECORD_AUDIO permission.")
                requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
            }
        }
    }

    // ================ FILE SHARING ================
    private fun shareFile(uri: android.net.Uri, mimeType: String) {
        Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, uri)
            type = mimeType
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }.let { shareIntent ->
            startActivity(Intent.createChooser(shareIntent, "Share Log File"))
        }
    }

    // ================ DIALOG LISTENER IMPLEMENTATIONS ================
    override fun onShareLog() {
        viewModel.onShareLog()
    }

    override fun onClearLog() {
        viewModel.onClearLog()
    }

    override fun onRequestPermission() {
        Log.i(TAG, "User requested permission from settings dialog.")
        requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }

    override fun onForceConnect() {
        viewModel.onForceConnect()
    }

    override fun onSettingsSaved() {
        viewModel.onSettingsSaved()
    }
}