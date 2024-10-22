package com.huanshankeji.kobweb.compose.ui.modifiers

import com.huanshankeji.compose.foundation.layout.ext.cssHeightStretchValueBrowserDependent
import com.huanshankeji.compose.foundation.layout.ext.cssWidthStretchValueBrowserDependent
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.css.height
import com.varabyte.kobweb.compose.css.width
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.maxWidth


/**
 * A default modifier for all layouts to make them more consistent with `androidx.compose` behavior.
 */
fun Modifier.imitateAndroidxLayout() =
    styleModifier {
        width(Width.FitContent)
        height(Height.FitContent)
        maxWidth(cssWidthStretchValueBrowserDependent)
        maxHeight(cssHeightStretchValueBrowserDependent)
    }
