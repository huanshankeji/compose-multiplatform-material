package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    androidx.compose.material3.Button(onClick, modifier.platformModifier, enabled) {
        ButtonScope.content()
    }

actual object ButtonScope {
    @Composable
    actual fun Icon() {
        TODO()
    }
}
