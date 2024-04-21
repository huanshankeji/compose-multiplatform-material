package com.huanshankeji.compose.material.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.Text
import com.huanshankeji.compose.ui.Modifier

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
    androidx.compose.material.TextField(
        value,
        onValueChange,
        modifier.platformModifier,
        enabled = enabled,
        label = label?.let { { Text(it) } },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = singleLine
    )

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
    androidx.compose.material.OutlinedTextField(
        value,
        onValueChange,
        modifier.platformModifier,
        enabled = enabled,
        label = label?.let { { Text(it) } },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = singleLine
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
    androidx.compose.material.TextField(
        value,
        onValueChange,
        modifier.platformModifier,
        enabled = enabled,
        label = label?.let { { Text(it) } },
        maxLines = lines,
        minLines = lines
    )
