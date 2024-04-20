package com.huanshankeji.compose.foundation.ext

import com.huanshankeji.compose.foundation.layout.ColumnScope
import com.huanshankeji.compose.ui.Modifier

// TODO use context receivers
/**
 * Delegates to `weight` on `androidx.compose` and `height` on JS.
 */
expect fun Modifier.weightOrHeight(columnScope: ColumnScope, weight: Float, heightPercentage: Int): Modifier
