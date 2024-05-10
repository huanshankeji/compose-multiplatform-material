package com.huanshankeji.compose.material2.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.ui.Modifier

expect class NavigationIconScope {
    @Composable
    fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit)

    @Composable
    fun MaterialIconNavButton(onClick: () -> Unit, icon: Icon, contentDescription: String?)
}

expect class TopAppBarActionsScope {
    @Composable
    fun ActionButton(onClick: () -> Unit, content: @Composable () -> Unit)

    @Composable
    fun MaterialIconActionButton(onClick: () -> Unit, icon: Icon, contentDescription: String?)
}

@Composable
expect fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    topAppBarModifier: Modifier = Modifier,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)? = null,
    actions: @Composable TopAppBarActionsScope.() -> Unit = {},
    content: @Composable () -> Unit
)
