package com.huanshankeji.compose.layout

import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.toPx
import com.varabyte.kobweb.compose.ui.modifiers.size

/**
 * @see toPx
 */
actual fun Modifier.size(dp: Dp): Modifier =
    platformModify { size(dp.toPx()) }
