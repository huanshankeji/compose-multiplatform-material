package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

expect /*value*/ class ButtonScope {
    @Composable
    fun Label(text: String)
}

@Composable
expect fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit)


//expect class TopAppBarActionsScope
@Composable
expect fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable /*TopAppBarActionsScope.*/() -> Unit = {},
    content: @Composable () -> Unit
)
