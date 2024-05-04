package com.huanshankeji.compose.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.*
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.web.attributes.isFalseOrNull
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLElement

private fun Modifier.toCommonIconButtonAttrs(
    onClick: () -> Unit
): AttrsScope<HTMLElement>.() -> Unit =
    platformModifier.toAttrs {
        onClick { onClick() }
    }

private fun Modifier.toCommonIconToggleButtonAttrs(
    checked: Boolean, onCheckedChange: (Boolean) -> Unit
): AttrsScope<HTMLElement>.() -> Unit =
    toCommonIconButtonAttrs { onCheckedChange(!checked) }

private fun (@Composable () -> Unit).toCommonIconButtonContent(): @Composable MdIconButtonScope.() -> Unit =
    { this@toCommonIconButtonContent() }

@Composable
actual fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconButtonAttrs(onClick),
        content = content.toCommonIconButtonContent()
    )


@Composable
actual fun IconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdIconButton(
        enabled.isFalseOrNull(),
        /*
        // There is no need to use these attributes according to the docs.
        toggle = true,
        selected = checked,
        */
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = content.toCommonIconButtonContent()
    )

@Composable
actual fun FilledIconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdFilledIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconButtonAttrs(onClick),
        content = content.toCommonIconButtonContent()
    )

@Composable
actual fun FilledIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdFilledIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = content.toCommonIconButtonContent()
    )

@Composable
actual fun FilledTonalIconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdFilledTonalIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconButtonAttrs(onClick),
        content = content.toCommonIconButtonContent()
    )

@Composable
actual fun FilledTonalIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdFilledTonalIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = content.toCommonIconButtonContent()
    )

@Composable
actual fun OutlinedIconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdOutlinedIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconButtonAttrs(onClick),
        content = content.toCommonIconButtonContent()
    )

@Composable
actual fun OutlinedIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable () -> Unit
) =
    MdOutlinedIconButton(
        enabled.isFalseOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = content.toCommonIconButtonContent()
    )
