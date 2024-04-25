package com.huanshankeji.compose.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.enabledToNullableDisabled
import com.huanshankeji.compose.html.material3.MdCheckbox
import com.huanshankeji.compose.html.material3.MdCheckboxState
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
actual fun Checkbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier,
    enabled: Boolean
) =
    MdCheckbox(
        if (checked) MdCheckboxState.Checked else MdCheckboxState.Unchecked,
        enabled.enabledToNullableDisabled(),
        attrs = modifier.platformModifier.toAttrs {
            onCheckedChange?.let { onClick { it(!checked) } }
            //onCheckedChange?.let { onInput { it(!checked) } }
        }
    )
