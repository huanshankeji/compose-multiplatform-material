package com.huanshankeji.compose.material2.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.contentDescription
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.layout.fillMaxSize
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.material2.icons.mdcIconWithStyle
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.toAttrs
import dev.petuska.kmdc.top.app.bar.*
import org.jetbrains.compose.web.dom.Text

actual class NavigationIconScope(val mdcTopAppBarSectionScope: MDCTopAppBarSectionScope) {
    @Composable
    actual fun NavButton(onClick: () -> Unit, modifier: Modifier, content: @Composable () -> Unit) =
        mdcTopAppBarSectionScope.NavButton(attrs = modifier.toAttrs { onClick { onClick() } }) { content() }

    @Composable
    actual fun MaterialIconNavButton(onClick: () -> Unit, modifier: Modifier, icon: Icon, contentDescription: String?) =
        mdcTopAppBarSectionScope.NavButton(attrs = modifier.toAttrs {
            mdcIconWithStyle()
            contentDescription(contentDescription)
        }) { Text(icon.name) }
}

actual class TopAppBarActionsScope(val mdcTopAppBarSectionScope: MDCTopAppBarSectionScope) {
    @Composable
    actual fun ActionButton(onClick: () -> Unit, modifier: Modifier, content: @Composable () -> Unit) =
        mdcTopAppBarSectionScope.ActionButton(attrs = modifier.toAttrs { onClick { onClick() } }) { content() }

    @Composable
    actual fun MaterialIconActionButton(
        onClick: () -> Unit, modifier: Modifier, icon: Icon, contentDescription: String?
    ) =
        mdcTopAppBarSectionScope.ActionButton(attrs = modifier.toAttrs {
            onClick { onClick() }
            mdcIconWithStyle()
            contentDescription(contentDescription)
        }) { Text(icon.name) }
}

@Composable
actual fun PrimitiveTopAppBarScaffold(
    title: @Composable () -> Unit,
    topAppBarModifier: Modifier,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)?,
    actions: @Composable TopAppBarActionsScope.() -> Unit,
    contentModifier: Modifier,
    content: @Composable () -> Unit
) =
    MDCTopAppBar {
        TopAppBar(topAppBarModifier.toAttrs()) {
            Row {
                Section(align = MDCTopAppBarSectionAlign.Start) {
                    navigationIcon?.let { NavigationIconScope(this@Section).it() }
                    Title { title() }
                }
                Section(
                    align = MDCTopAppBarSectionAlign.End,
                    attrs = {
                        attr("role", "toolbar")
                    }
                ) {
                    TopAppBarActionsScope(this).actions()
                }
            }
        }
        Main(contentModifier.toAttrs()) { content() }
    }

/**
 * It's highly recommended to read the KDoc in the common module.
 */
@Composable
actual fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    topAppBarModifier: Modifier,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)?,
    actions: @Composable TopAppBarActionsScope.() -> Unit,
    bottomBar: @Composable (() -> Unit)?,
    snackbarHost: @Composable (() -> Unit)?,
    content: @Composable () -> Unit
) =
    Column(Modifier.fillMaxSize()) {
        PrimitiveTopAppBarScaffold(
            title,
            topAppBarModifier,
            navigationIcon,
            actions,
            Modifier.weight(1f),
            content
        )
        snackbarHost?.let { it() }
        bottomBar?.invoke()
    }
