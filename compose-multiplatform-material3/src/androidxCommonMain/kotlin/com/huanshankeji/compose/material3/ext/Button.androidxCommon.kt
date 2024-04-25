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

@Composable
actual fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) = androidx.compose.material3.ElevatedButton(onClick, modifier.platformModifier, enabled) {
    ButtonScope.content()
}

@Composable
actual fun FilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    androidx.compose.material3.FilledTonalButton(onClick, modifier.platformModifier, enabled) {
        ButtonScope.content()
    }

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    androidx.compose.material3.OutlinedButton(onClick, modifier.platformModifier, enabled) {
        ButtonScope.content()
    }

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    androidx.compose.material3.TextButton(onClick, modifier.platformModifier, enabled) {
        ButtonScope.content()
    }

actual object ButtonScope {
    @Composable
    actual fun Icon() {
        TODO()
    }
}
