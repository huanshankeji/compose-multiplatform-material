package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Divider(modifier: Modifier) =
    androidx.compose.material.Divider(modifier.platformModifier)
