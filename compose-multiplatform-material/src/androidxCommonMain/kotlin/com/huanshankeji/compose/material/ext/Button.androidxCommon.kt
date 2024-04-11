package com.huanshankeji.compose.material.ext

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.ext.ButtonType.*
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.Modifier

@Suppress("NAME_SHADOWING")
@Composable
actual fun Button(
    onClick: () -> Unit,
    buttonType: ButtonType,
    modifier: Modifier,
    content: @Composable ButtonScope.() -> Unit
) {
    val modifier = modifier.platformModifier
    val content: @Composable RowScope.() -> Unit = { ButtonScope(this).content() }
    when (buttonType) {
        Contained -> androidx.compose.material.Button(onClick, modifier, content = content)
        Outlined -> OutlinedButton(onClick, modifier, content = content)
        Text -> TextButton(onClick, modifier, content = content)
    }
}

actual class ButtonScope(val rowScope: RowScope) {
    @Composable
    actual fun Label(text: String) =
        androidx.compose.material.Text(text)
}

actual abstract class ButtonElement : Element()
