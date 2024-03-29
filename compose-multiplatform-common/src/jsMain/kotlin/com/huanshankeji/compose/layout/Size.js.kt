package com.huanshankeji.compose.layout

import androidx.annotation.FloatRange
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.toPercent
import com.huanshankeji.compose.ui.unit.toPx
import com.varabyte.kobweb.compose.ui.modifiers.*

@Stable
actual fun Modifier.width(width: Dp): Modifier =
    platformModify { width(width.toPx()) }

@Stable
actual fun Modifier.height(height: Dp): Modifier =
    platformModify { height(height.toPx()) }

@Stable
actual fun Modifier.size(dp: Dp): Modifier =
    platformModify { size(dp.toPx()) }

@Stable
actual fun Modifier.size(width: Dp, height: Dp): Modifier =
    platformModify { size(width.toPx(), height.toPx()) }

// TODO Are the outcomes visually consistent?
// TODO What happens with `Dp.Unspecified`?

@Stable
actual fun Modifier.widthIn(min: Dp, max: Dp): Modifier =
    platformModify { minWidth(min.toPx()).maxWidth(max.toPx()) }

@Stable
actual fun Modifier.heightIn(min: Dp, max: Dp): Modifier =
    platformModify { minHeight(min.toPx()).maxHeight(max.toPx()) }

@Stable
actual fun Modifier.sizeIn(minWidth: Dp, minHeight: Dp, maxWidth: Dp, maxHeight: Dp): Modifier =
    platformModify {
        minWidth(minWidth.toPx()).minHeight(minHeight.toPx()).maxWidth(maxWidth.toPx()).maxHeight(maxHeight.toPx())
    }

@Stable
actual fun Modifier.fillMaxWidth(@FloatRange(from = 0.0, to = 1.0) fraction: Float): Modifier =
    platformModify { fillMaxWidth(fraction.toPercent()) }

@Stable
actual fun Modifier.fillMaxHeight(@FloatRange(from = 0.0, to = 1.0) fraction: Float): Modifier =
    platformModify { fillMaxHeight(fraction.toPercent()) }

actual fun Modifier.fillMaxSize(@FloatRange(from = 0.0, to = 1.0) fraction: Float): Modifier =
    platformModify { fillMaxSize(fraction.toPercent()) }
