package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.*
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.web.attributes.ext.onInput
import com.huanshankeji.compose.web.attributes.isFalseOrNull
import com.huanshankeji.compose.web.attributes.isTrueOrNull
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLElement

private fun Modifier.toCommonIconToggleButtonAttrs(
    checked: Boolean, onCheckedChange: (Boolean) -> Unit
): AttrsScope<HTMLElement>.() -> Unit =
    platformModifier.toAttrs {
        // note that `onInput` is used here
        onInput { onCheckedChange(!checked) }
    }

private fun commonIconToggleButtonContent(
    uncheckedContent: @Composable () -> Unit,
    checkedContent: @Composable (Modifier) -> Unit
): @Composable MdIconButtonScope.() -> Unit = {
    uncheckedContent()
    checkedContent(Modifier.platformModify { attrsModifier { slotEqSelected() } })
}


@Composable
actual fun IconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    uncheckedContent: @Composable () -> Unit,
    checkedContent: @Composable (Modifier) -> Unit
) =
    MdIconButton(
        enabled.isFalseOrNull(),
        toggle = true,
        selected = checked.isTrueOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = commonIconToggleButtonContent(uncheckedContent, checkedContent)
    )


@Composable
actual fun FilledIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    uncheckedContent: @Composable () -> Unit,
    checkedContent: @Composable (Modifier) -> Unit
) =
    MdFilledIconButton(
        enabled.isFalseOrNull(),
        toggle = true,
        selected = checked.isTrueOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = commonIconToggleButtonContent(uncheckedContent, checkedContent)
    )

@Composable
actual fun FilledTonalIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    uncheckedContent: @Composable () -> Unit,
    checkedContent: @Composable (Modifier) -> Unit
) =
    MdFilledTonalIconButton(
        enabled.isFalseOrNull(),
        toggle = true,
        selected = checked.isTrueOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = commonIconToggleButtonContent(uncheckedContent, checkedContent)
    )

@Composable
actual fun OutlinedIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    uncheckedContent: @Composable () -> Unit,
    checkedContent: @Composable (Modifier) -> Unit
) =
    MdOutlinedIconButton(
        enabled.isFalseOrNull(),
        toggle = true,
        selected = checked.isTrueOrNull(),
        attrs = modifier.toCommonIconToggleButtonAttrs(checked, onCheckedChange),
        content = commonIconToggleButtonContent(uncheckedContent, checkedContent)
    )
