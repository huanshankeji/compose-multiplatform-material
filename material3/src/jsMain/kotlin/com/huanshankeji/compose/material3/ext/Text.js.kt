package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun TaglessText(text: String) =
    Text(text)