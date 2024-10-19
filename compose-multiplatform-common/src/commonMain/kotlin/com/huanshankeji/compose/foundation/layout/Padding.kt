package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.foundation.onClick
import com.huanshankeji.compose.ui.Modifier

/**
 * See KDoc of the overload with one parameter for platform differences.
 */
@Stable
expect fun Modifier.padding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp): Modifier

/**
 * See KDoc of the overload with one parameter for platform differences.
 */
@Stable
expect fun Modifier.padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): Modifier

/**
 * Padding works differently on `androidx.compose` and CSS.
 * In `androidx.compose`, the `padding` modifier adds a layer of wrapper around the component, and [order of modifiers matters](https://developer.android.com/develop/ui/compose/modifiers#order-modifier-matters);
 * while in CSS, this function delegates to the `margin` CSS properties.
 *
 * As a result, for consistency on different platforms, it's recommend to put [padding] before the others such as [background] and [onClick],
 * and if you want to add inner padding (corresponding to the CSS `padding`) for the content of a component, you are recommended to wrap the content with a [Box] with [padding].
 */
@Stable
expect fun Modifier.padding(all: Dp): Modifier

@Stable
expect fun Modifier.padding(paddingValues: PaddingValues): Modifier

@Stable
expect fun Modifier.absolutePadding(left: Dp = 0.dp, top: Dp = 0.dp, right: Dp = 0.dp, bottom: Dp = 0.dp): Modifier

// copied and adapted from `androidx.compose.foundation.layout.Padding.kt`

@Stable
expect abstract class PaddingValues {
    @Immutable
    class Absolute(
        /*@Stable*/
        left: Dp = 0.dp,
        /*@Stable*/
        top: Dp = 0.dp,
        /*@Stable*/
        right: Dp = 0.dp,
        /*@Stable*/
        bottom: Dp = 0.dp
    ) : PaddingValues
}

@Stable
expect fun PaddingValues(all: Dp): PaddingValues

@Stable
expect fun PaddingValues(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): PaddingValues

@Stable
expect fun PaddingValues(
    start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp
): PaddingValues
