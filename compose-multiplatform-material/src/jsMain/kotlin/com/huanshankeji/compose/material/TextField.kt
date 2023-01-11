package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import dev.petuska.kmdc.textfield.MDCTextField
import org.w3c.dom.HTMLInputElement

actual typealias TextFieldElement = HTMLInputElement

@Composable
actual fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifierOrAttrs: ModifierOrAttrs<TextFieldElement>,
    enabled: Boolean,
    label: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
) =
    MDCTextField(value,
        attrs = {
            onInput { onValueChange(it.value) }
            modifierOrAttrs.toAttrs()?.let { it() }
        },
        disabled = !enabled,
        label = label,
        leadingIcon = leadingIcon?.let { { it() } },
        trailingIcon = trailingIcon?.let { { it() } }
    )
