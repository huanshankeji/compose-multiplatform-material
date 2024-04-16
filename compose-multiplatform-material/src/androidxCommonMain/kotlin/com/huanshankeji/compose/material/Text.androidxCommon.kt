package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual abstract class TextElement : Element()

@Composable
actual fun Text(text: String, modifierOrAttrs: ModifierOrAttrs<TextElement>) =
    androidx.compose.material.Text(text, modifierOrAttrs.toModifier())
