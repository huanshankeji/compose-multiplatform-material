package com.huanshankeji.compose.material.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.textfield.MDCTextArea
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldType

@Composable
fun CommonTextField(
    value: String,
    type: MDCTextFieldType,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    label: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?
) =
    MDCTextField(
        value,
        type,
        !enabled,
        label,
        leadingIcon = leadingIcon?.let { { it() } },
        trailingIcon = trailingIcon?.let { { it() } },
        attrs = modifier.platformModifier.toAttrs {
            onInput { onValueChange(it.value) }
        }
    )

@Composable
actual fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    label: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    singleLine: Boolean
) =
    CommonTextField(value, MDCTextFieldType.Filled, onValueChange, modifier, enabled, label, leadingIcon, trailingIcon)

@Composable
actual fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    label: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    singleLine: Boolean
) =
    CommonTextField(
        value, MDCTextFieldType.Outlined, onValueChange, modifier, enabled, label, leadingIcon, trailingIcon
    )

@Composable
actual fun TextArea(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    label: String?,
    lines: Int
) =
    MDCTextArea(
        value,
        disabled = !enabled,
        label = label,
        rows = lines.toUInt(),
        attrs = modifier.platformModifier.toAttrs {
            onInput { onValueChange(it.value) }
        })
