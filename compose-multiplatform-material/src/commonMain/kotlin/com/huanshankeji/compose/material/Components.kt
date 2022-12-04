package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon

expect /*value*/ class ButtonScope {
    @Composable
    fun Label(text: String)
}

@Composable
expect fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit)


@Composable
expect fun Icon(materialIcon: MaterialIcon)


@Composable
expect fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit)


expect class NavigationIconScope {
    @Composable
    fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit)

    @Composable
    fun MaterialIconNavButton(onClick: () -> Unit, materialIcon: MaterialIcon)
}

expect class TopAppBarActionsScope {
    @Composable
    fun ActionButton(onClick: () -> Unit, content: @Composable () -> Unit)

    @Composable
    fun MaterialIconActionButton(onClick: () -> Unit, materialIcon: MaterialIcon)
}

@Composable
expect fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)? = null,
    actions: @Composable TopAppBarActionsScope.() -> Unit = {},
    content: @Composable () -> Unit
)
