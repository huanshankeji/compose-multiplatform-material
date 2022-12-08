package com.huanshankeji.compose.material

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon

actual class ButtonScope(val rowScope: RowScope) {
    @Composable
    actual fun Label(text: String) =
        Text(text)
}

@Composable
actual fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit) =
    androidx.compose.material.Button(onClick) { ButtonScope(this).content() }


@Composable
actual fun Card(content: @Composable () -> Unit) =
    androidx.compose.material.Card { content() }


@Composable
actual fun Icon(materialIcon: MaterialIcon) =
    androidx.compose.material.Icon(materialIcon, null)
// no `contentDescription` for now


@Composable
actual fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit) =
    androidx.compose.material.IconButton(onClick = onClick, content = content)


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
