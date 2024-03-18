package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual abstract class CardElement : Element()

@Composable
actual fun Card(modifierOrAttrs: ModifierOrAttrs<CardElement>, content: @Composable () -> Unit) =
    androidx.compose.material.Card(modifierOrAttrs.toModifier()) { content() }
