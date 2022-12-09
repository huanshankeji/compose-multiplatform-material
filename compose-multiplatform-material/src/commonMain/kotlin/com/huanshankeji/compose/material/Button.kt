package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect /*value*/ class ButtonScope {
    @Composable
    fun Label(text: String)
}

expect abstract class ButtonElement : Element

@Composable
expect fun Button(
    onClick: () -> Unit,
    modifierOrAttrs: ModifierOrAttrs<ButtonElement> = null,
    content: @Composable ButtonScope.() -> Unit
)
