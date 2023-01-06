package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import com.huanshankeji.compose.web.attributes.attrs
import com.huanshankeji.compose.web.attributes.plus
import com.huanshankeji.compose.web.css.FIT_CONTENT
import com.huanshankeji.compose.web.css.width
import dev.petuska.kmdc.card.MDCCard
import org.w3c.dom.HTMLDivElement

actual typealias CardElement = HTMLDivElement

@Composable
actual fun Card(modifierOrAttrs: ModifierOrAttrs<CardElement>, content: @Composable () -> Unit) =
    MDCCard(attrs = attrs<CardElement> {
        style { width(FIT_CONTENT) }
    } + modifierOrAttrs.toAttrs()) { content() }
