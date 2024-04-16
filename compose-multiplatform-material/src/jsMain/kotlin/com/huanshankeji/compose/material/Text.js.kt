package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.BasicText
import com.huanshankeji.compose.ui.ModifierOrAttrs
import org.w3c.dom.HTMLSpanElement

actual typealias TextElement = HTMLSpanElement

@Composable
actual fun Text(text: String, modifierOrAttrs: ModifierOrAttrs<TextElement>) =
    BasicText(text, modifierOrAttrs)
