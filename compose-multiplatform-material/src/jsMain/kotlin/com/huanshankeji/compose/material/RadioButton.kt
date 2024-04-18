package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import dev.petuska.kmdc.radio.MDCRadio

@Composable
actual fun RadioButton(selected: Boolean, onClick: (() -> Unit)?, modifier: Modifier, enabled: Boolean) =
    MDCRadio(selected, disabled = !enabled, attrs = {
        if (onClick !== null) onClick { onClick() }
    })
