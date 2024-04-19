package com.huanshankeji.compose.foundation

import com.huanshankeji.compose.ui.Modifier

expect fun Modifier.onClick(onClick: () -> Unit): Modifier
