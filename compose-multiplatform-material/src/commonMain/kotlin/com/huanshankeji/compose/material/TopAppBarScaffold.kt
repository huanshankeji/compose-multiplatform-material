package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon

expect class NavigationIconScope {
    @Composable
    fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit)

    @Composable
    fun MaterialIconNavButton(onClick: () -> Unit, materialIcon: MaterialIcon, contentDescription: String?)
}

expect class TopAppBarActionsScope {
    @Composable
    fun ActionButton(onClick: () -> Unit, content: @Composable () -> Unit)

    @Composable
    fun MaterialIconActionButton(onClick: () -> Unit, materialIcon: MaterialIcon, contentDescription: String?)
}

@Composable
expect fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)? = null,
    actions: @Composable TopAppBarActionsScope.() -> Unit = {},
    content: @Composable () -> Unit
)
