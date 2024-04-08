package com.huanshankeji.compose.foundation.text

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import androidx.compose.foundation.text.BasicText as PlatformBasicText

@Composable
actual fun BasicText(text: String) =
    PlatformBasicText(text)

@Composable
actual fun BasicText(text: String, modifier: Modifier) =
    PlatformBasicText(text, modifier.platformModifier)
