package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class TextFieldElement : Element

@Composable
expect fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifierOrAttrs: ModifierOrAttrs<TextFieldElement> = null,
    enabled: Boolean = true,
    label: String? = null,
    /*
    placeholder: String? = null,
    helperText: String? = null,
    */
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
)
