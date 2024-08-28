package com.huanshankeji.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.foundation.ext.css.horizontalScroll
import com.huanshankeji.compose.foundation.ext.css.verticalScroll
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.PlatformModifier
import com.varabyte.kobweb.compose.ui.styleModifier

fun PlatformModifier.verticalScroll() =
    styleModifier { verticalScroll() }

fun PlatformModifier.horizontalScroll() =
    styleModifier { horizontalScroll() }

val verticalScrollPlatformModifier = PlatformModifier.verticalScroll()
val horizontalScrollPlatformModifier = PlatformModifier.horizontalScroll()


@Composable
actual fun rememberScrollState(initial: Int): ScrollState =
    ScrollState

@Stable
actual object ScrollState

actual fun Modifier.verticalScroll(state: ScrollState): Modifier =
    platformModify { verticalScroll() }


actual fun Modifier.horizontalScroll(state: ScrollState): Modifier =
    platformModify { horizontalScroll() }

