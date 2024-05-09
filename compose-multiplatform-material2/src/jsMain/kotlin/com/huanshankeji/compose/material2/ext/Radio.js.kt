package com.huanshankeji.compose.material2.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.toAttrs
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.radio.MDCRadio

// see: https://github.com/mpetuska/kmdc/blob/master/sandbox/src/jsMain/showcases/MDCRadio.kt

@Composable
actual fun RadioRow(selected: Boolean, label: String, onClick: () -> Unit, modifier: Modifier, enabled: Boolean) =
    MDCRadio(selected, disabled = !enabled, label = label, attrs = modifier.toAttrs {
        onClick { onClick() }
    })

@Composable
actual fun RadioGroupRow(modifier: Modifier, content: @Composable () -> Unit) =
    MDCFormField(attrs = modifier.toAttrs()) {
        content()
    }
