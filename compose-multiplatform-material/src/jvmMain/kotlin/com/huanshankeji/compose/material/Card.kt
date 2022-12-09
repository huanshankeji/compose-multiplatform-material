package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

@Composable
actual fun Card(content: @Composable () -> Unit) =
    androidx.compose.material.Card { content() }
