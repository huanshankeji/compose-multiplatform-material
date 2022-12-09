package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import dev.petuska.kmdcx.icons.MDCIconSpan
import org.w3c.dom.HTMLSpanElement

actual typealias IconElement = HTMLSpanElement

/**
 * There is often a better alternative of adding the CSS rule to the parent element to using this composable directly.
 */
@Composable
actual fun Icon(materialIcon: MaterialIcon, modifierOrAttrs: ModifierOrAttrs<IconElement>) =
    MDCIconSpan(materialIcon.mdcIcon, attrs = modifierOrAttrs.toAttrs())
