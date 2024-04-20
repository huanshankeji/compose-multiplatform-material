package com.huanshankeji.compose.foundation.ext

import com.huanshankeji.compose.foundation.layout.ColumnScope
import com.huanshankeji.compose.ui.Modifier

actual fun Modifier.weightOrHeight(
    columnScope: ColumnScope, weight: Float, heightPercentage: Int
): Modifier =
    with(columnScope.platformValue) { platformModify { weight(weight) } }
