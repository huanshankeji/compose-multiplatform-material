package com.huanshankeji.compose.material

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

actual class ButtonScope(val rowScope: RowScope) {
    @Composable
    actual fun Label(text: String) =
        Text(text)
}

@Composable
actual fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit) =
    androidx.compose.material.Button(onClick = onClick) { ButtonScope(this).content() }
