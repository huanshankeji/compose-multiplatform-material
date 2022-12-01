package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import org.w3c.dom.HTMLButtonElement

actual class ButtonScope(val mdcButtonScope: MDCButtonScope<HTMLButtonElement>) {
    @Composable
    actual fun Label(text: String) =
        mdcButtonScope.Label(text)
}

@Composable
actual fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit) =
    MDCButton(attrs = { onClick { onClick() } }) { ButtonScope(this).content() }
