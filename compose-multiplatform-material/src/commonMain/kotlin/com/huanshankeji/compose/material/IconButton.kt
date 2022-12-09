package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

@Composable
expect fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit)
