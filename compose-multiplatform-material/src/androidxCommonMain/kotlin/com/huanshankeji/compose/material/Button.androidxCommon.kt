package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    androidx.compose.material.Button(onClick, modifier.platformModifier) {
        RowScope.Impl(this).content()
    }

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    androidx.compose.material.OutlinedButton(onClick, modifier.platformModifier) {
        RowScope.Impl(this).content()
    }

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    androidx.compose.material.TextButton(onClick, modifier.platformModifier) {
        RowScope.Impl(this).content()
    }