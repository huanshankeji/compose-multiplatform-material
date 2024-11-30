package com.huanshankeji.compose.foundation.layout.ext

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.foundation.clickable
import com.huanshankeji.compose.foundation.layout.PaddingValues
import com.huanshankeji.compose.ui.Modifier

/**
 * See the KDoc of the overload with one [Dp] parameter for platform differences.
 */
@Stable
expect fun Modifier.outerPadding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp): Modifier

/**
 * See the KDoc of the overload with one [Dp] parameter for platform differences.
 */
@Stable
expect fun Modifier.outerPadding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): Modifier

/**
 * This delegates to the CSS `margin` property on JS DOM and adds the padding outside.
 * For consistency on different platforms, please use it as the **first** modifier **before** the other modifiers such as [background] and [clickable].
 * See the KDoc of the [padding] overload with one [Dp] parameter for more information.
 * @see innerPadding
 */
@Stable
expect fun Modifier.outerPadding(all: Dp): Modifier

/**
 * See the KDoc of the overload with one [Dp] parameter for platform differences.
 */
@Stable
expect fun Modifier.outerPadding(paddingValues: PaddingValues): Modifier

/**
 * See the KDoc of the overload with one [Dp] parameter for platform differences.
 */
@Stable
expect fun Modifier.absoluteOuterPadding(left: Dp = 0.dp, top: Dp = 0.dp, right: Dp = 0.dp, bottom: Dp = 0.dp): Modifier
