package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual abstract class TextFieldElement : Element()

@Composable
actual fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifierOrAttrs: ModifierOrAttrs<TextFieldElement>,
    enabled: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
) =
    androidx.compose.material.TextField(
        value,
        onValueChange,
        modifierOrAttrs.toModifier(),
        enabled = enabled,
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
