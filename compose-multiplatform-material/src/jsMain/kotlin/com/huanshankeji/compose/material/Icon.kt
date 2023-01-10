package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import com.huanshankeji.compose.web.attributes.attrs
import com.huanshankeji.compose.web.attributes.plus
import dev.petuska.kmdcx.icons.MDCIconSpan
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLSpanElement

actual typealias IconElement = HTMLSpanElement

/**
 * There is often a better alternative of adding the CSS rule to the parent element to using this composable directly.
 */
@Composable
actual fun Icon(
    materialIcon: MaterialIcon, contentDescription: String?, modifierOrAttrs: ModifierOrAttrs<IconElement>
) =
    MDCIconSpan(materialIcon.mdcIcon, attrs = attrs<IconElement> {
        contentDescription(contentDescription)
    } + modifierOrAttrs.toAttrs())

fun AttrsScope<*>.contentDescription(contentDescription: String?) =
    contentDescription?.let {
        // aria-label's semantics don't seem to meet the requirements perfectly because it labels an interactive element
        // see: https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/Attributes/aria-label, https://stackoverflow.com/questions/22039910/what-is-aria-label-and-how-should-i-use-it
        //attr("aria-label", it)

        title(it)
    }
