package com.huanshankeji.compose.material2

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.yield
import kotlin.coroutines.resume

// copied and adapted from `SnackbarHost.kt` in `androidx.compose.material`

@Stable
abstract class SnackbarHostStateCommonImpl {
    private val mutex = Mutex()
    var currentSnackbarData by mutableStateOf<SnackbarDataCommonInterface?>(null)
        private set

    abstract val yieldUntilNext: Boolean
    abstract val delayMillisUntilNext: Long

    suspend fun showSnackbar(
        message: String,
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short
    ): SnackbarResult = mutex.withLock {
        try {
            println("Entered mutex") // TODO remove
            return suspendCancellableCoroutine { continuation ->
                println("Set: $message") // TODO remove
                currentSnackbarData = SnackbarDataImpl(message, actionLabel, duration, continuation)
            }
        } finally {
            println("Cleared") // TODO remove
            currentSnackbarData = null

            // a workaround to trigger recomposition when `currentSnackbarData` is set to `null`, resolving the issue that a series of continuous snackbars don't show
            if (yieldUntilNext) yield()
            delay(delayMillisUntilNext)
        }
    }

    @Stable
    private class SnackbarDataImpl(
        override val message: String,
        override val actionLabel: String?,
        override val duration: SnackbarDuration,
        private val continuation: CancellableContinuation<SnackbarResult>
    ) : SnackbarDataCommonInterface {

        override fun performAction() {
            if (continuation.isActive) continuation.resume(SnackbarResult.ActionPerformed)
        }

        override fun dismiss() {
            if (continuation.isActive) continuation.resume(SnackbarResult.Dismissed)
        }
    }
}

interface SnackbarDataCommonInterface {
    val message: String
    val actionLabel: String?
    val duration: SnackbarDuration
    fun performAction()
    fun dismiss()
}

enum class SnackbarResult {
    Dismissed, ActionPerformed
}

enum class SnackbarDuration {
    Short, Long, Indefinite
}
