package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

expect /*value*/ class ButtonScope {
    @Composable
    fun Label(text: String)
}

@Composable
expect fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit)
