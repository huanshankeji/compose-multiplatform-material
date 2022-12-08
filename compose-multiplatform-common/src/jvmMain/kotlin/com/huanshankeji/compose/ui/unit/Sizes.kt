package com.huanshankeji.compose.ui.unit

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual abstract class SizeValue(val platformValue: Dp)
actual class DpOrPxValue(platformValue: Dp) : SizeValue(platformValue)

actual val Int.dpOrPx: DpOrPxValue
    get() = DpOrPxValue(this.dp)
