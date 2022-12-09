package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import com.huanshankeji.compose.web.attributes.attrs
import com.huanshankeji.compose.web.attributes.plus
import dev.petuska.kmdc.icon.button.MDCIconButton
import org.w3c.dom.HTMLButtonElement

actual typealias IconButtonElement = HTMLButtonElement

@Composable
actual fun IconButton(
    onClick: () -> Unit,
    modifierOrAttrs: ModifierOrAttrs<IconButtonElement>,
    content: @Composable () -> Unit
) =
    MDCIconButton(attrs = attrs<IconButtonElement> {
        onClick { onClick() }
    } + modifierOrAttrs.toAttrs()) { content() }
