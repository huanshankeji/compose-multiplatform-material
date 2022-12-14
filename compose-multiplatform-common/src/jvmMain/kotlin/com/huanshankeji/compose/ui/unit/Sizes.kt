package com.huanshankeji.compose.ui.unit

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual abstract class NumericSize(val platformValue: Dp)
actual class DpOrPx(platformValue: Dp) : NumericSize(platformValue)

actual val Int.dpOrPx: DpOrPx
    get() = DpOrPx(this.dp)
