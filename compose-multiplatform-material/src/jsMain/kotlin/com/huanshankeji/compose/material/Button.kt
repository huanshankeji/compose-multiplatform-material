package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import com.huanshankeji.compose.web.attributes.attrs
import com.huanshankeji.compose.web.attributes.plus
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import org.w3c.dom.HTMLButtonElement

actual class ButtonScope(val mdcButtonScope: MDCButtonScope<HTMLButtonElement>) {
    @Composable
    actual fun Label(text: String) =
        mdcButtonScope.Label(text)
}

actual typealias ButtonElement = HTMLButtonElement

@Composable
actual fun Button(
    onClick: () -> Unit, modifierOrAttrs: ModifierOrAttrs<ButtonElement>, content: @Composable ButtonScope.() -> Unit
) =
    MDCButton(attrs = attrs<ButtonElement> {
        onClick { onClick() }
    } + modifierOrAttrs.toAttrs()) {
        ButtonScope(this).content()
    }

