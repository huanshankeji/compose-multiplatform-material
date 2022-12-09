package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class CardElement : Element

@Composable
expect fun Card(modifierOrAttrs: ModifierOrAttrs<CardElement> = null, content: @Composable () -> Unit)
