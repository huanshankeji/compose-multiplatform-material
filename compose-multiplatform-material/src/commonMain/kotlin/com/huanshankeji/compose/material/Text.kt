package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

/**
 * The `com.huanshankeji.compose.material.Text` function
 * can be easily confused with other Composable functions named `Text`
 * such as `androidx.compose.material.Text` and `org.jetbrains.compose.web.dom.Text`
 * if not careful.
 * @see com.huanshankeji.compose.material.ext.MaterialText
 */
@Composable
expect fun Text(text: String, modifier: Modifier = Modifier)
