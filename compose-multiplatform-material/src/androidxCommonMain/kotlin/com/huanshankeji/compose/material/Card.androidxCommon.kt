package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Card(modifier: Modifier, content: @Composable () -> Unit) =
    androidx.compose.material.Card(modifier.platformModifier, content = content)
