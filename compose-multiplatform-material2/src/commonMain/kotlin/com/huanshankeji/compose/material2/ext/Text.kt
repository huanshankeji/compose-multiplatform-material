package com.huanshankeji.compose.material2.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material2.Text
import com.huanshankeji.compose.ui.Modifier

/**
 * An explicit alias of [Text].
 */
@Composable
inline fun MaterialText(text: String, modifier: Modifier = Modifier) =
    Text(text, modifier)

/**
 * Delegates to raw inline text without any element on JS / Compose HTML.
 * @see com.huanshankeji.compose.foundation.text.ext.InlineBasicText
 */
@Composable
expect fun InlineText(text: String)
