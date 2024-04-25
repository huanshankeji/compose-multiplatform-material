package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.MdButtonScope
import com.huanshankeji.compose.material3.*
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    CommonButton(onClick, modifier, enabled) {
        ButtonScope(this).content()
    }

@Composable
actual fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    CommonElevatedButton(onClick, modifier, enabled) {
        ButtonScope(this).content()
    }

@Composable
actual fun FilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    CommonFilledTonalButton(onClick, modifier, enabled) {
        ButtonScope(this).content()
    }

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    CommonOutlinedButton(onClick, modifier, enabled) {
        ButtonScope(this).content()
    }

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable ButtonScope.() -> Unit
) =
    CommonTextButton(onClick, modifier, enabled) {
        ButtonScope(this).content()
    }

actual class ButtonScope(val mdButtonScope: MdButtonScope) {
    @Composable
    actual fun Icon() {
        TODO()
    }
}
