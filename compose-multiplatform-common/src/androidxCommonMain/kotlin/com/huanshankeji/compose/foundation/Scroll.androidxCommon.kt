package com.huanshankeji.compose.foundation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Modifier
import androidx.compose.foundation.ScrollState as PlatformScrollState

@Composable
actual fun rememberScrollState(initial: Int): ScrollState =
    ScrollState(rememberScrollState(initial))

@Stable
actual class ScrollState(val platformValue: PlatformScrollState) {
    actual constructor(initial: Int) : this(PlatformScrollState(initial))

    actual val value: Int
        get() = platformValue.value

    actual suspend fun animateScrollTo(value: Int) =
        platformValue.animateScrollTo(value)

    actual suspend fun scrollTo(value: Int): Float =
        platformValue.scrollTo(value)
}

actual fun Modifier.verticalScroll(state: ScrollState): Modifier =
    platformModify { verticalScroll(state.platformValue) }

actual fun Modifier.horizontalScroll(state: ScrollState): Modifier =
    platformModify { horizontalScroll(state.platformValue) }
