package com.huanshankeji.compose.material.ext

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.Icon
import com.huanshankeji.compose.material.IconButton
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.ui.Modifier

actual class NavigationIconScope private constructor() {
    @Composable
    actual fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        IconButton(onClick, content = content)

    @Composable
    actual fun MaterialIconNavButton(onClick: () -> Unit, icon: Icon, contentDescription: String?) =
        IconButton(onClick) { Icon(icon, contentDescription) }

    companion object {
        val instance = NavigationIconScope()
    }
}

actual class TopAppBarActionsScope(val rowScope: RowScope) {
    @Composable
    actual fun ActionButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        IconButton(onClick, content = content)

    @Composable
    actual fun MaterialIconActionButton(onClick: () -> Unit, icon: Icon, contentDescription: String?) =
        IconButton(onClick) { Icon(icon, contentDescription) }

}

@Composable
actual fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    topAppBarModifier: Modifier,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)?,
    actions: @Composable TopAppBarActionsScope.() -> Unit,
    content: @Composable () -> Unit
) =
    Scaffold(topBar = {
        TopAppBar(
            title,
            topAppBarModifier.platformModifier,
            navigationIcon?.let { { NavigationIconScope.instance.it() } },
            { TopAppBarActionsScope(this).actions() })
    }) { content() }
