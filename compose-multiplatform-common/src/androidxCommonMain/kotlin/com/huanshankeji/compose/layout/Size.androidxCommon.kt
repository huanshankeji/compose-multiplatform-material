package com.huanshankeji.compose.layout

import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.ui.Modifier

actual fun Modifier.size(dp: Dp) =
    platformModify { size(dp) }
