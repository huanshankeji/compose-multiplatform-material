package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.card.MDCCard

@Composable
actual fun Card(content: @Composable () -> Unit) =
    MDCCard { content() }
