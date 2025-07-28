package com.data

import java.util.UUID

// FIXED: This file now ONLY contains the TranslationItem. No more redeclaration errors.
data class TranslationItem(
    val text: String,
    val isUser: Boolean,
    val id: String = UUID.randomUUID().toString()
)