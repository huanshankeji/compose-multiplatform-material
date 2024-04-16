package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdcx.icons.MDCIconSpan
import org.jetbrains.compose.web.attributes.AttrsScope

/**
 * There is often a better alternative of adding the CSS rule to the parent element to using this composable directly.
 */
@Composable
actual fun Icon(icon: Icon, contentDescription: String?, modifier: Modifier) =
    MDCIconSpan(icon.mdcIcon, attrs = modifier.platformModifier.toAttrs {
        contentDescription(contentDescription)
    })

internal fun AttrsScope<*>.contentDescription(contentDescription: String?) =
    contentDescription?.let {
        // aria-label's semantics don't seem to meet the requirements perfectly because it labels an interactive element
        // see: https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/Attributes/aria-label, https://stackoverflow.com/questions/22039910/what-is-aria-label-and-how-should-i-use-it
        //attr("aria-label", it)

        title(it)
    }
