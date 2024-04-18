package com.huanshankeji.compose.foundation

import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick

actual fun Modifier.onClick(onClick: () -> Unit): Modifier =
    platformModify { onClick { onClick() } }
