package com.huanshankeji.compose.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Text(text: String, modifier: Modifier) =
    androidx.compose.material3.Text(text, modifier.platformModifier)
