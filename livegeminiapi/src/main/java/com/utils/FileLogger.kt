package com.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileLogger {
    private const val WEB_SOCKET_LOG_FILE = "websocket_log.txt"
    private const val APP_LOG_FILE = "app_log.txt"

    private fun getLogDirectory(context: Context): File? {
        val dir = File(
            context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
            "LiveTransLogs"
        )
        return try {
            if (!dir.exists()) {
                dir.mkdirs()
            }
            dir
        } catch (e: Exception) {
            Log.e("FileLogger", "Error creating log directory", e)
            null
        }
    }

    private fun writeToFile(context: Context, fileName: String, message: String) {
        val logDir = getLogDirectory(context) ?: return
        try {
            val file = File(logDir, fileName)
            val timestamp = SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS",
                Locale.getDefault()
            ).format(Date())
            FileWriter(file, true).use { writer ->
                writer.append("[$timestamp] $message\n\n")
            }
        } catch (e: Exception) {
            Log.e("FileLogger", "Failed to write to $fileName", e)
        }
    }

    fun logWebSocket(context: Context, data: String) {
        if (data.contains("\"mime_type\": \"audio/pcm\"")) {
            val logMessage = "--- RAW SERVER RESPONSE (Contains audio/pcm, excluded) ---"
            writeToFile(context, WEB_SOCKET_LOG_FILE, logMessage)
            return
        }

        val prettyJson = try {
            GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(JsonParser.parseString(data))
        } catch (e: Exception) {
            data
        }

        val logMessage = """
            --- RAW SERVER RESPONSE ---
            $prettyJson
            ---------------------------
        """.trimIndent()

        writeToFile(context, WEB_SOCKET_LOG_FILE, logMessage)
    }

    fun logInfo(context: Context, tag: String, message: String) {
        Log.i(tag, message)
        writeToFile(context, APP_LOG_FILE, "INFO [$tag]: $message")
    }

    fun logError(context: Context, tag: String, message: String, throwable: Throwable? = null) {
        Log.e(tag, message, throwable)
        val stackTrace = throwable?.stackTraceToString()?.let { "\n$it" } ?: ""
        writeToFile(context, APP_LOG_FILE, "ERROR [$tag]: $message$stackTrace")
    }

    fun shareLogFile(context: Context): Uri? {
        val logDir = getLogDirectory(context) ?: return null
        val logFile = File(logDir, APP_LOG_FILE)

        return try {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                logFile
            )
        } catch (e: Exception) {
            Log.e("FileLogger", "Failed to create shareable URI", e)
            null
        }
    }

    fun showShareIntent(context: Context, uri: Uri) {
        try {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND // CORRECTED: Use 'action' property instead of 'Intent.setAction' [cite: 7]
                        putExtra(Intent.EXTRA_STREAM, uri)
                type = "text/plain" // CORRECTED: Use 'type' property instead of 'Intent.setType' [cite: 8]
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            context.startActivity(
                Intent.createChooser(shareIntent, "Share Log File")
            )
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                context,
                "No app available to handle sharing",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}