package com.huanshankeji.compose.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

actual typealias BoxElement = HTMLDivElement

@Composable
actual fun Box(modifierOrAttrs: ModifierOrAttrs<BoxElement>, content: @Composable () -> Unit) =
    Div(modifierOrAttrs.toAttrs()) { content() }
