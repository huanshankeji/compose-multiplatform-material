package com.huanshankeji.compose.material2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Modifier
import dev.petuska.kmdc.snackbar.MDCSnackbarAttrsScope
import kotlinx.coroutines.delay

// copied and adapted from `SnackbarHost.kt` in `androidx.compose.material`

@Stable
actual class SnackbarHostState(val platformValue: SnackbarHostStateCommonImpl) {
    actual constructor() : this(object : SnackbarHostStateCommonImpl() {
        override val yieldUntilNext: Boolean
            get() = false
        override val delayMillisUntilNext: Long
            get() = 20 // for 60 Hz displays
    })

    actual val currentSnackbarData: SnackbarData?
        get() = platformValue.currentSnackbarData?.toCommonValue()

    actual suspend fun showSnackbar(
        message: String,
        actionLabel: String?,
        duration: SnackbarDuration
    ): SnackbarResult =
        platformValue.showSnackbar(message, actionLabel, duration)
}

@Stable
actual class SnackbarData(val platformValue: SnackbarDataCommonInterface) {
    actual val message: String
        get() = platformValue.message
    actual val actionLabel: String?
        get() = platformValue.actionLabel
    actual val duration: SnackbarDuration
        get() = platformValue.duration

    actual fun performAction() = platformValue.performAction()

    actual fun dismiss() = platformValue.dismiss()
}

fun SnackbarDataCommonInterface.toCommonValue() =
    SnackbarData(this)

@Composable
actual fun SnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier,
    actionOnNewLine: Boolean
) {
    val currentSnackbarData = hostState.currentSnackbarData?.platformValue

    /*
    // problem: doesn't close the snack bar before opening a new one when opening a series of snackbars, and only shows 2 snackbar messages
    // works without the `close` event in `CommonSnackbar`

    val duration: Long?
    if (currentSnackbarData !== null) {
        duration = currentSnackbarData.duration.toMillis()
        // An alternative approach is to listen for the close event.
        LaunchedEffect(currentSnackbarData) {
            delay(duration)
            currentSnackbarData.dismiss()
        }
    } else
        duration = null

    // not put in a conditional block to reduce DOM recomposition
    CommonSnackbar(actionOnNewLine, currentSnackbarData !== null, /*duration?.toInt(),*/ modifier, currentSnackbarData)
    */

    /*
    // Problem: doesn't open a series of snackbars
    // works with the `close` event in `CommonSnackbar`

    // An alternative approach is to listen for the close event.
    // There is a small bug with this implementation that the snackbar doesn't close before a new one opens.
    LaunchedEffect(currentSnackbarData) {
        if (currentSnackbarData !== null) {
            val duration = currentSnackbarData.duration.toMillis()
            delay(duration)
            currentSnackbarData.dismiss()
        }
    }

    // not put in a conditional block to reduce DOM recomposition
    // `timeoutMs` not used anymore because it doesn't work well when opening a series of snackbars
    CommonSnackbar(actionOnNewLine, currentSnackbarData !== null, /*duration?.toInt(),*/ modifier, currentSnackbarData)
    */

    /*
    // Problem: doesn't open a series of snackbars

    if (currentSnackbarData !== null) {
        LaunchedEffect(currentSnackbarData) {
            val duration = currentSnackbarData.duration.toMillis()
            delay(duration)
            currentSnackbarData.dismiss()
        }

        val duration = currentSnackbarData.duration.toMillis()
        CommonSnackbar(actionOnNewLine, true, duration.toInt(), modifier, currentSnackbarData)
    }
    */

    val duration: Long?
    if (currentSnackbarData !== null) {
        duration = currentSnackbarData.duration.toMillis()
        /**
         * It seems possible that the [SnackbarHostStateCommonImpl.delayMillisUntilNext] in [SnackbarHostState] is not enough to trigger recomposition,
         * the snackbar is updated with the next [SnackbarData],
         * the [MDCSnackbarAttrsScope.onClosed] in [CommonSnackbar] is never called,
         * and [SnackbarHostStateCommonImpl.mutex] never gets unlocked.
         * This [LaunchedEffect] makes sure it's unlocked, though some queuing snackbars may not show when this happens.
         */
        // An alternative approach is to listen for the close event.
        LaunchedEffect(currentSnackbarData) {
            delay(duration)
            currentSnackbarData.dismiss()
        }
    } else
        duration = null

    // not put in a conditional block to reduce DOM recomposition
    CommonSnackbar(actionOnNewLine, currentSnackbarData !== null, duration?.toInt(), modifier, currentSnackbarData)
}

internal fun SnackbarDuration.toMillis(
    //hasAction: Boolean,
    //accessibilityManager: AccessibilityManager?
): Long =
    when (this) {
        SnackbarDuration.Indefinite -> Long.MAX_VALUE
        SnackbarDuration.Long -> 10000L
        SnackbarDuration.Short -> 4000L
    }
