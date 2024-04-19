package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.checkbox.MDCCheckbox

// https://github.com/mpetuska/kmdc/blob/master/sandbox/src/jsMain/showcases/MDCCheckbox.kt
@Composable
actual fun Checkbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier,
    enabled: Boolean
) =
    MDCCheckbox(checked, !enabled, attrs = modifier.platformModifier.toAttrs {
        onCheckedChange?.let { onInput { it(!checked) } }
    })
