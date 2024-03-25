package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.radio.MDCRadio

@Composable
actual fun RadioButton(selected: Boolean, onClick: (() -> Unit)?, enabled: Boolean) =
    MDCRadio(selected, disabled = !enabled, attrs = {
        if (onClick !== null) onClick { onClick() }
    })
