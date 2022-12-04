package com.huanshankeji.compose

import androidx.compose.runtime.Composable

@Composable
actual fun Text(text: String) =
    org.jetbrains.compose.web.dom.Text(text)
