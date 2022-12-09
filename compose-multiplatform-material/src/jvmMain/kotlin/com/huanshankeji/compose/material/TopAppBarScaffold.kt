package com.huanshankeji.compose.material

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon

actual class NavigationIconScope private constructor() {
    @Composable
    actual fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        IconButton(onClick, content)

    @Composable
    actual fun MaterialIconNavButton(onClick: () -> Unit, materialIcon: MaterialIcon) =
        IconButton(onClick) { Icon(materialIcon) }

    companion object {
        val instance = NavigationIconScope()
    }
}

actual class TopAppBarActionsScope(val rowScope: RowScope) {
    @Composable
    actual fun ActionButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        IconButton(onClick, content)

    @Composable
    actual fun MaterialIconActionButton(onClick: () -> Unit, materialIcon: MaterialIcon) =
        IconButton(onClick) { Icon(materialIcon) }

}

@Composable
actual fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)?,
    actions: @Composable TopAppBarActionsScope.() -> Unit,
    content: @Composable () -> Unit
) =
    Scaffold(topBar = {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon?.let { { NavigationIconScope.instance.it() } },
            actions = { TopAppBarActionsScope(this).actions() })
    }) { content() }
