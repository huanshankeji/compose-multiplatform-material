package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

@Composable
actual fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit) =
    androidx.compose.material.IconButton(onClick = onClick, content = content)
