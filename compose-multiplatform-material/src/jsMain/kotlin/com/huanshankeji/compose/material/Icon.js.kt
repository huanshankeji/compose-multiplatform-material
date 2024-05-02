package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.contentDescription
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.material.icons.toMDCIcon
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdcx.icons.MDCIconSpan

/**
 * There is often a better alternative of adding the CSS rule to the parent element to using this composable directly.
 */
@Composable
actual fun Icon(icon: Icon, contentDescription: String?, modifier: Modifier) =
    MDCIconSpan(icon.toMDCIcon(), attrs = modifier.platformModifier.toAttrs {
        contentDescription(contentDescription)
    })
