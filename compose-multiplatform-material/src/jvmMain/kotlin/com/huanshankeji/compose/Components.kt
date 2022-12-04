package com.huanshankeji.compose

import androidx.compose.runtime.Composable

@Composable
actual fun Text(text: String) =
    androidx.compose.material.Text(text)
