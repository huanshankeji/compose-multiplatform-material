package com.huanshankeji.compose.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.foundation.onClick
import com.huanshankeji.compose.ui.Modifier

/**
 * See KDoc of the overload with one parameter for platform differences.
 */
@Stable
actual fun Modifier.padding(start: Dp, top: Dp, end: Dp, bottom: Dp): Modifier =
    platformModify { padding(start, top, end, bottom) }

/**
 * See KDoc of the overload with one parameter for platform differences.
 */
@Stable
actual fun Modifier.padding(horizontal: Dp, vertical: Dp): Modifier =
    platformModify { padding(horizontal, vertical) }

/**
 * Padding works differently on `androidx.compose` and CSS.
 * In `androidx.compose`, the `padding` modifier adds a layer of wrapper around the component, and [order of modifiers matters](https://developer.android.com/develop/ui/compose/modifiers#order-modifier-matters);
 * while in CSS, this function delegates to the `margin` CSS properties.
 *
 * As a result, for consistency on different platforms, it's recommend to put [padding] before the others such as [background] and [onClick],
 * and if you want to add inner padding (corresponding to the CSS `padding`) for the content of a component, you are recommended to wrap the content with a [Box] with [padding].
 */
@Stable
actual fun Modifier.padding(all: Dp): Modifier =
    platformModify { padding(all) }

@Stable
actual fun Modifier.absolutePadding(left: Dp, top: Dp, right: Dp, bottom: Dp): Modifier =
    platformModify { absolutePadding(left, top, right, bottom) }
