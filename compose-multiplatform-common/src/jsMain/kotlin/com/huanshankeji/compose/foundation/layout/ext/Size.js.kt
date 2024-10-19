package com.huanshankeji.compose.foundation.layout.ext

import androidx.compose.runtime.Stable
import com.huanshankeji.browser.Browser
import com.huanshankeji.browser.browser
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.web.css.height
import com.huanshankeji.compose.web.css.width
import com.varabyte.kobweb.compose.ui.styleModifier

private const val CSS_STRETCH_VALUE = "stretch" // This does not work on Chrome.
private val cssStretchValueBrowserDependent =
    when (browser) {
        Browser.Webkit -> "-webkit-fill-available"
        Browser.Mozilla -> "-moz-available"
        null -> ""
    }

@Stable
actual fun Modifier.fillMaxWidthStretch(): Modifier =
    platformModify { styleModifier { width(cssStretchValueBrowserDependent) } }

@Stable
actual fun Modifier.fillMaxHeightStretch(): Modifier =
    platformModify { styleModifier { height(cssStretchValueBrowserDependent) } } // Setting this for `height` seems to be not available on Firefox. See https://developer.mozilla.org/en-US/docs/Web/CSS/height#browser_compatibility.

@Stable
actual fun Modifier.fillMaxSizeStretch(): Modifier =
    platformModify {
        styleModifier {
            width(cssStretchValueBrowserDependent)
            height(cssStretchValueBrowserDependent) // Setting this for `height` seems to be not available on Firefox. See https://developer.mozilla.org/en-US/docs/Web/CSS/height#browser_compatibility.
        }
    }
