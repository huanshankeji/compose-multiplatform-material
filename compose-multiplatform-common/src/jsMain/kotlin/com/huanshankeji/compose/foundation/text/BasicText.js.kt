package com.huanshankeji.compose.foundation.text

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun BasicText(text: String) =
    Text(text)

@Composable
actual fun BasicText(text: String, modifier: Modifier) =
    SpanText(text, modifier.platformModifier)
