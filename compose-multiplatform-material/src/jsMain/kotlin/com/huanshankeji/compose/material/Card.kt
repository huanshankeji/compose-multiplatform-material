package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.modifierOrAttrs
import com.huanshankeji.compose.ui.plus
import com.huanshankeji.compose.ui.toAttrs
import com.huanshankeji.compose.ui.unit.Size
import dev.petuska.kmdc.card.MDCCard
import org.w3c.dom.HTMLDivElement

actual typealias CardElement = HTMLDivElement

@Composable
actual fun Card(modifierOrAttrs: ModifierOrAttrs<CardElement>, content: @Composable () -> Unit) =
    MDCCard(attrs = (modifierOrAttrs<CardElement> {
        style { width(Size.FitContent) }
    } + modifierOrAttrs).toAttrs()) { content() }
