package com.huanshankeji.compose.foundation.ext

import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.ui.Modifier

// TODO use context receivers
/**
 * Delegates to `weight` on `androidx.compose` and `width` on JS.
 */
expect fun Modifier.weightOrWidth(rowScope: RowScope, weight: Float, widthPercentage: Int): Modifier
