package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.toPx
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.marginInline

@Stable
actual fun Modifier.padding(start: Dp, top: Dp, end: Dp, bottom: Dp): Modifier =
    platformModify {
        marginInline(start.toPx(), end.toPx())
            .margin {
                top(top.toPx())
                bottom(bottom.toPx())
            }
    }

@Stable
actual fun Modifier.padding(horizontal: Dp, vertical: Dp): Modifier =
    platformModify { margin(vertical.toPx(), horizontal.toPx()) }

@Stable
actual fun Modifier.padding(all: Dp): Modifier =
    platformModify { margin(all.toPx()) }

@Stable
actual fun Modifier.padding(paddingValues: PaddingValues): Modifier =
    when (paddingValues) {
        is PaddingValues.Absolute -> with(paddingValues) { absolutePadding(left, top, right, bottom) }
        is PaddingValuesImpl -> with(paddingValues) { padding(start, top, end, bottom) }
        else -> throw IllegalArgumentException(paddingValues.toString())
    }

@Stable
actual fun Modifier.absolutePadding(left: Dp, top: Dp, right: Dp, bottom: Dp): Modifier =
    platformModify { margin(top.toPx(), right.toPx(), bottom.toPx(), left.toPx()) }

// copied and adapted from `androidx.compose.foundation.layout.Padding.kt`

@Stable
actual abstract class PaddingValues internal constructor() {
    @Immutable
    actual class Absolute actual constructor(
        @Stable
        val left: Dp,
        @Stable
        val top: Dp,
        @Stable
        val right: Dp,
        @Stable
        val bottom: Dp
    ) : PaddingValues()
}

@Stable
actual fun PaddingValues(all: Dp): PaddingValues =
    PaddingValuesImpl(all, all, all, all)

@Stable
actual fun PaddingValues(horizontal: Dp, vertical: Dp): PaddingValues =
    PaddingValuesImpl(horizontal, vertical, horizontal, vertical)

@Stable
actual fun PaddingValues(start: Dp, top: Dp, end: Dp, bottom: Dp): PaddingValues =
    PaddingValuesImpl(start, top, end, bottom)

@Immutable
internal class PaddingValuesImpl(
    @Stable
    val start: Dp,
    @Stable
    val top: Dp,
    @Stable
    val end: Dp,
    @Stable
    val bottom: Dp
) : PaddingValues()
