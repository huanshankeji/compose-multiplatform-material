package com.huanshankeji.compose.material

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual class ButtonScope(val rowScope: RowScope) {
    @Composable
    actual fun Label(text: String) =
        androidx.compose.material.Text(text)
}

actual abstract class ButtonElement : Element()

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifierOrAttrs: ModifierOrAttrs<ButtonElement>,
    content: @Composable ButtonScope.() -> Unit
) =
    androidx.compose.material.Button(onClick, modifierOrAttrs.toModifier()) { ButtonScope(this).content() }
