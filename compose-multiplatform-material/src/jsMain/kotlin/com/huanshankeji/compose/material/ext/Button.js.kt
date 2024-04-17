package com.huanshankeji.compose.material.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.ext.ButtonType.*
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.button.MDCButtonType
import org.w3c.dom.HTMLButtonElement

@Composable
actual fun Button(
    onClick: () -> Unit,
    buttonType: ButtonType,
    modifier: Modifier,
    content: @Composable ButtonScope.() -> Unit
) =
    MDCButton(buttonType.toMDCButtonType(),
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        ButtonScope(this).content()
    }

actual class ButtonScope(val mdcButtonScope: MDCButtonScope<HTMLButtonElement>) {
    @Composable
    actual fun Label(text: String) =
        mdcButtonScope.Label(text)
}

fun ButtonType.toMDCButtonType() =
    when (this) {
        Contained -> MDCButtonType.Raised
        Outlined -> MDCButtonType.Outlined
        Text -> MDCButtonType.Text
    }
