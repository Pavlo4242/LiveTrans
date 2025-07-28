package com.data

/**
 * A sealed class to represent all possible connection states in a type-safe way.
 * This replaces ambiguous booleans and strings with a single, comprehensive state object.
 */
sealed class ConnectionState {
    /** The WebSocket is disconnected and idle. */
    object Idle : ConnectionState()

    /** Actively trying to establish a connection. */
    object Connecting : ConnectionState()

    /** The connection is established and ready. */
    object Connected : ConnectionState()

    /** The connection was lost and is attempting to reconnect. */
    data class Reconnecting(val attempt: Int) : ConnectionState()

    /** The connection failed with a specific error. */
    data class Failed(val error: String) : ConnectionState()
}