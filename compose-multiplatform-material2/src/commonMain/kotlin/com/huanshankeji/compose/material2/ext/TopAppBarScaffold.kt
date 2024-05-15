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

/**
 * This one doesn't fill parent height on JS.
 */
@Composable
expect fun PrimitiveTopAppBarScaffold(
    title: @Composable () -> Unit,
    topAppBarModifier: Modifier = Modifier,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)? = null,
    actions: @Composable TopAppBarActionsScope.() -> Unit = {},
    contentModifier: Modifier = Modifier,
    content: @Composable () -> Unit
)

/**
 * This variant fills parent space automatically and internally uses a flexbox on JS.
 * For it to work properly, it's recommended to set these CSS styles on body:
 * ```
 * body {
 *     margin: 0;
 *     height: 100vh;
 * }
 * ```
 */
@Composable
expect fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    topAppBarModifier: Modifier = Modifier,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)? = null,
    actions: @Composable TopAppBarActionsScope.() -> Unit = {},
    bottomBar: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
)
