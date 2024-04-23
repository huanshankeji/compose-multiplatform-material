package com.huanshankeji.compose.layout

import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Modifier

private const val DEPRECATION_MESSAGE =
    "This API doesn't work as expected, is not consistent on both platforms, and is temporarily deprecated."

@Deprecated(DEPRECATION_MESSAGE)
@Stable
expect fun Modifier.width(intrinsicSize: IntrinsicSize): Modifier

@Deprecated(DEPRECATION_MESSAGE)
@Stable
expect fun Modifier.height(intrinsicSize: IntrinsicSize): Modifier

@Deprecated(DEPRECATION_MESSAGE)
enum class IntrinsicSize { Min, Max }
