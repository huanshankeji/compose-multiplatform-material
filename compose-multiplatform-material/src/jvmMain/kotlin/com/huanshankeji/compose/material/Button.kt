package com.huanshankeji.compose.material

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.ButtonType.*
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
    buttonType: ButtonType,
    modifierOrAttrs: ModifierOrAttrs<ButtonElement>,
    content: @Composable ButtonScope.() -> Unit
) {
    val modifier = modifierOrAttrs.toModifier()
    val androidxContent: @Composable RowScope.() -> Unit = { ButtonScope(this).content() }
    when (buttonType) {
        Contained -> androidx.compose.material.Button(onClick, modifier, content = androidxContent)
        Outlined -> OutlinedButton(onClick, modifier, content = androidxContent)
        Text -> TextButton(onClick, modifier, content = androidxContent)
    }
}
