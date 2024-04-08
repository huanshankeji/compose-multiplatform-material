package com.huanshankeji.compose.foundation.text

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

@Composable
expect fun BasicText(
    text: String
)

@Composable
expect fun BasicText(
    text: String,
    modifier: Modifier
)
