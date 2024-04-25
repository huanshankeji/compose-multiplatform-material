package com.huanshankeji.compose.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.html.material3.*
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
internal fun CommonButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable MdButtonScope.() -> Unit
) =
    MdFilledButton(disabled = if (enabled) null else true,
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        content()
    }

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) =
    CommonButton(onClick, modifier, enabled) {
        Row(content = content)
    }

@Composable
internal fun CommonElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable MdButtonScope.() -> Unit
) =
    MdElevatedButton(disabled = if (enabled) null else true,
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        content()
    }

@Composable
actual fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) =
    CommonElevatedButton(onClick, modifier, enabled) {
        Row(content = content)
    }

@Composable
internal fun CommonFilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable MdButtonScope.() -> Unit
) =
    MdFilledTonalButton(disabled = if (enabled) null else true,
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        content()
    }

@Composable
actual fun FilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) =
    CommonFilledTonalButton(onClick, modifier, enabled) {
        Row(content = content)
    }

@Composable
internal fun CommonOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable MdButtonScope.() -> Unit
) =
    MdOutlinedButton(disabled = if (enabled) null else true,
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        content()
    }

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) =
    CommonOutlinedButton(onClick, modifier, enabled) {
        Row(content = content)
    }

@Composable
internal fun CommonTextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable MdButtonScope.() -> Unit
) =
    MdTextButton(disabled = if (enabled) null else true,
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        content()
    }

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) =
    CommonTextButton(onClick, modifier, enabled) {
        Row(content = content)
    }
