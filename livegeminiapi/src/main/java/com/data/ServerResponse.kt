package com.data

import com.google.gson.annotations.SerializedName

// Represents the top-level structure of a JSON message from the server.
data class ServerResponse(
    val inputTranscription: Transcription? = null,
    val outputTranscription: Transcription? = null,
    val serverContent: ServerContent? = null,
    val sessionResumptionUpdate: SessionResumptionUpdate? = null
)

data class Transcription(
    val text: String?
)

data class ServerContent(
    val modelTurn: ModelTurn? = null,
    val turnComplete: Boolean? = false
)

data class ModelTurn(
    val parts: List<Part>? = null
)

data class Part(
    val inlineData: InlineData? = null
)

data class InlineData(
    val mimeType: String?,
    val data: String? // Base64 encoded audio
)

data class SessionResumptionUpdate(
    val resumable: Boolean?,
    @SerializedName("new_handle")
    val newHandle: String?
)
