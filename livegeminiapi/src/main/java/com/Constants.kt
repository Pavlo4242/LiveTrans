package com

object Constants {
    // This instruction guides the model's behavior for the translation task.
    const val SYSTEM_INSTRUCTION = """
    You are a live translation service.
    Translate what the user is saying in real-time.
    Be concise and accurate.
    """
}