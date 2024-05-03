package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.text.KeyboardActions
import com.huanshankeji.compose.foundation.text.KeyboardOptions
import com.huanshankeji.compose.foundation.text.attrsFrom
import com.huanshankeji.compose.html.material3.MdFilledTextField
import com.huanshankeji.compose.html.material3.MdOutlinedTextField
import com.huanshankeji.compose.html.material3.MdTextFieldScope
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.toCommonModifier
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
    onValueChange: (String) -> Unit, keyboardOptions: KeyboardOptions, keyboardActions: KeyboardActions,
): AttrsScope<HTMLElement>.() -> Unit =
    platformModifier.toAttrs {
        // see https://stackoverflow.com/questions/574941/best-way-to-track-onchange-as-you-type-in-input-type-text
        onInput { onValueChange(it.target.value) }

        // TODO `keyboardOptions.imeAction` is not working because `enterkeyhint` is not passed to the underlying `input`.
        attrsFrom(keyboardOptions, keyboardActions)
    }

private fun TextFieldContent(
    leadingIcon: @Composable ((Modifier) -> Unit)?,
    trailingIcon: @Composable ((Modifier) -> Unit)?,
): @Composable MdTextFieldScope.() -> Unit = {
    leadingIcon?.invoke(PlatformModifier.attrsModifier { slot(MdTextFieldScope.Slot.LeadingIcon) }.toCommonModifier())
    trailingIcon?.invoke(PlatformModifier.attrsModifier { slot(MdTextFieldScope.Slot.TrailingIcon) }.toCommonModifier())
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
        placeholder = placeholder,
        readOnly = readOnly.isTrueOrNull(),

        attrs = modifier.toTextFieldAttrs(onValueChange, keyboardOptions, keyboardActions),
        content = TextFieldContent(leadingIcon, trailingIcon)
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
        placeholder = placeholder,
        readOnly = readOnly.isTrueOrNull(),

        attrs = modifier.toTextFieldAttrs(onValueChange, keyboardOptions, keyboardActions),
        content = TextFieldContent(leadingIcon, trailingIcon)
    )
