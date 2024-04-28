package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.MdFilledTextField
import com.huanshankeji.compose.html.material3.MdOutlinedTextField
import com.huanshankeji.compose.html.material3.MdTextFieldScope
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.web.attributes.ext.onInput
import com.huanshankeji.compose.web.attributes.isFalseOrNull
import com.huanshankeji.compose.web.attributes.isTrueOrNull
import com.huanshankeji.compose.web.dom.ext.value
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLElement
import com.varabyte.kobweb.compose.ui.Modifier as PlatformModifier

private fun Modifier.toTextFieldAttrs(
    onValueChange: (String) -> Unit
): AttrsScope<HTMLElement>.() -> Unit =
    platformModifier.toAttrs {
        onInput { onValueChange(it.target.value) }
    }

private fun TextFieldContent(): @Composable MdTextFieldScope.() -> Unit = {
    // leadingIcon?.invoke() // TODO
    PlatformModifier.attrsModifier { slot(MdTextFieldScope.Slot.LeadingIcon) }
    // trailingIcon?.invoke() // TODO
    PlatformModifier.attrsModifier { slot(MdTextFieldScope.Slot.TrailingIcon) }
}

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
    singleLine: Boolean,
    lines: Int
) =
    MdFilledTextField(
        enabled.isFalseOrNull(),
        isError.isTrueOrNull(),
        supportingText, // TODO Is passing `supportingText` as `errorText` correct?
        label,
        value = value,
        prefixText = prefix,
        suffixText = suffix,
        hasLeadingIcon = leadingIcon?.let { true },
        hasTrailingIcon = trailingIcon?.let { true },
        supportingText = supportingText,
        rows = if (singleLine) null else lines,
        //inputMode = TODO(),
        placeholder = placeholder,
        readOnly = readOnly.isTrueOrNull(),

        attrs = modifier.toTextFieldAttrs(onValueChange),
        content = TextFieldContent()
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
    singleLine: Boolean,
    lines: Int
) =
    MdOutlinedTextField(
        enabled.isFalseOrNull(),
        isError.isTrueOrNull(),
        supportingText, // TODO Is passing `supportingText` as `errorText` correct?
        label,
        value = value,
        prefixText = prefix,
        suffixText = suffix,
        hasLeadingIcon = leadingIcon?.let { true },
        hasTrailingIcon = trailingIcon?.let { true },
        supportingText = supportingText,
        rows = if (singleLine) null else lines,
        //inputMode = TODO(),
        placeholder = placeholder,
        readOnly = readOnly.isTrueOrNull(),

        attrs = modifier.toTextFieldAttrs(onValueChange),
        content = TextFieldContent()
    )
