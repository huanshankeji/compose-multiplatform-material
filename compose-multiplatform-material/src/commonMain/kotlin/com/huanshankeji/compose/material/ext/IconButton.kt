package com.huanshankeji.compose.material.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.Icon
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.ui.Modifier

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Icon,
    contentDescription: String?
) =
    com.huanshankeji.compose.material.IconButton(onClick, modifier) { Icon(icon, contentDescription) }
