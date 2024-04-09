package com.huanshankeji.compose.foundation.text.ext

import androidx.compose.runtime.Composable

/**
 * Delegates to raw text without any element on JS / Compose HTML.
 */
@Composable
expect fun InlineBasicText(text: String)
