package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.icon.button.MDCIconButton

@Composable
actual fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit) =
    MDCIconButton(attrs = {
        onClick { onClick() }
    }) { content() }
