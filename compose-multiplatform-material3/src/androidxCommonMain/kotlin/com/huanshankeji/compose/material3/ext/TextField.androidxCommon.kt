package com.huanshankeji.compose.material3.ext

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.text.KeyboardActions
import com.huanshankeji.compose.foundation.text.KeyboardOptions
import com.huanshankeji.compose.foundation.text.toPlatformValue
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.material3.Icon
import com.huanshankeji.compose.ui.Modifier

// This function can be moved into a common file.
fun String?.ToNullableTextComposable(): (@Composable () -> Unit)? =
    this?.let { { Text(it) } }

private fun (@Composable ((Modifier) -> Unit)?).toContentWithoutModifier(): @Composable (() -> Unit)? =
    this?.let { { it(Modifier) } }

private fun Icon?.toIconContent(): @Composable (() -> Unit)? =
    this?.let { { Icon(it, null) } }


@Composable
actual fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    prefix: String?,
    suffix: String?,
    supportingText: String?,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    lines: Int
) =
    androidx.compose.material3.TextField(
        value,
        onValueChange,
        modifier.platformModifier,
        enabled,
        readOnly,
        label = label.ToNullableTextComposable(),
        placeholder = placeholder.ToNullableTextComposable(),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix.ToNullableTextComposable(),
        suffix = suffix.ToNullableTextComposable(),
        supportingText = supportingText.ToNullableTextComposable(),
        isError = isError,
        keyboardOptions = keyboardOptions.toPlatformValue(),
        keyboardActions = keyboardActions.toPlatformValue(),
        singleLine = singleLine,
        maxLines = lines,
        minLines = lines
    )

@Composable
actual fun TextFieldWithModifierPassedToIcon(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: @Composable ((Modifier) -> Unit)?,
    trailingIcon: @Composable ((Modifier) -> Unit)?,
    prefix: String?,
    suffix: String?,
    supportingText: String?,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    lines: Int
) =
    TextField(
        value,
        onValueChange,
        modifier,
        enabled,
        readOnly,
        label,
        placeholder,
        leadingIcon.toContentWithoutModifier(),
        trailingIcon.toContentWithoutModifier(),
        prefix,
        suffix,
        supportingText,
        isError,
        keyboardOptions,
        keyboardActions,
        singleLine,
        lines
    )


@Composable
actual fun TextFieldWithMaterialIcons(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: Icon?,
    trailingIcon: Icon?,
    prefix: String?,
    suffix: String?,
    supportingText: String?,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    lines: Int
) =
    TextField(
        value,
        onValueChange,
        modifier,
        enabled,
        readOnly,
        label,
        placeholder,
        leadingIcon.toIconContent(),
        trailingIcon.toIconContent(),
        prefix,
        suffix,
        supportingText,
        isError,
        keyboardOptions,
        keyboardActions,
        singleLine,
        lines
    )


@Composable
actual fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    prefix: String?,
    suffix: String?,
    supportingText: String?,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    lines: Int
) =
    androidx.compose.material3.OutlinedTextField(
        value,
        onValueChange,
        modifier.platformModifier,
        enabled,
        readOnly,
        label = label.ToNullableTextComposable(),
        placeholder = placeholder.ToNullableTextComposable(),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix.ToNullableTextComposable(),
        suffix = suffix.ToNullableTextComposable(),
        supportingText = supportingText.ToNullableTextComposable(),
        isError = isError,
        keyboardOptions = keyboardOptions.toPlatformValue(),
        keyboardActions = keyboardActions.toPlatformValue(),
        singleLine = singleLine,
        maxLines = lines,
        minLines = lines
    )

@Composable
actual fun OutlinedTextFieldWithModifierPassedToIcon(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: @Composable ((Modifier) -> Unit)?,
    trailingIcon: @Composable ((Modifier) -> Unit)?,
    prefix: String?,
    suffix: String?,
    supportingText: String?,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    lines: Int
) =
    OutlinedTextField(
        value,
        onValueChange,
        modifier,
        enabled,
        readOnly,
        label,
        placeholder,
        leadingIcon.toContentWithoutModifier(),
        trailingIcon.toContentWithoutModifier(),
        prefix,
        suffix,
        supportingText,
        isError,
        keyboardOptions,
        keyboardActions,
        singleLine,
        lines
    )

@Composable
actual fun OutlinedTextFieldWithMaterialIcons(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    label: String?,
    placeholder: String?,
    leadingIcon: Icon?,
    trailingIcon: Icon?,
    prefix: String?,
    suffix: String?,
    supportingText: String?,
    isError: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    lines: Int
) =
    OutlinedTextField(
        value,
        onValueChange,
        modifier,
        enabled,
        readOnly,
        label,
        placeholder,
        leadingIcon.toIconContent(),
        trailingIcon.toIconContent(),
        prefix,
        suffix,
        supportingText,
        isError,
        keyboardOptions,
        keyboardActions,
        singleLine,
        lines
    )
