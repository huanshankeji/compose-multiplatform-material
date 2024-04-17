package com.huanshankeji.compose.foundation.text.ext

import androidx.compose.runtime.Composable

/**
 * Delegates to raw inline text without any element on JS / Compose HTML.
 */
@Composable
expect fun InlineBasicText(text: String)
