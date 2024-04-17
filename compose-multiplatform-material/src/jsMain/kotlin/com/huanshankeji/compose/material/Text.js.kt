package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.text.BasicText
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun Text(text: String, modifier: Modifier) =
    BasicText(text, modifier)
