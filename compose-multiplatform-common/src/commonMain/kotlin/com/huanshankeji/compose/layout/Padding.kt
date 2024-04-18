package com.huanshankeji.compose.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.ui.Modifier

@Stable
expect fun Modifier.padding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp): Modifier

@Stable
expect fun Modifier.padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): Modifier

@Stable
expect fun Modifier.padding(all: Dp): Modifier

@Stable
expect fun Modifier.absolutePadding(left: Dp = 0.dp, top: Dp = 0.dp, right: Dp = 0.dp, bottom: Dp = 0.dp): Modifier
