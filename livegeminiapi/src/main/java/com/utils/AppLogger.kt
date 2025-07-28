package com.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File
import java.util.Date

/**
 * An injectable logger for consistent logging and easier testing.
 */
class AppLogger(private val context: Context) {
    private val logFile = File(context.cacheDir, "session_log.txt")

    fun logInfo(tag: String, message: String) {
        Log.i(tag, message)
        writeToFile("INFO [$tag]: $message")
    }

    fun logDebug(tag: String, message: String) {
        Log.d(tag, message)
        writeToFile("DEBUG [$tag]: $message")
    }

    fun logError(tag: String, message: String, throwable: Throwable? = null) {
        Log.e(tag, message, throwable)
        val stackTrace = throwable?.stackTraceToString()?.let { "\n$it" } ?: ""
        writeToFile("ERROR [$tag]: $message$stackTrace")
    }

    fun getLogFile(): Uri {
        return FileProvider.getUriForFile(context, "${context.packageName}.provider", logFile)
    }

    private fun writeToFile(logMessage: String) {
        try {
            logFile.appendText("${Date()}: $logMessage\n")
        } catch (e: Exception) {
            Log.e("AppLogger", "Failed to write to log file", e)
        }
    }
}