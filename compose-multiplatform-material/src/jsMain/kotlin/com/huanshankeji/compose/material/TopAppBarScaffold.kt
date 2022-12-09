package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import dev.petuska.kmdc.top.app.bar.*
import dev.petuska.kmdcx.icons.mdcIcon

actual class NavigationIconScope(val mdcTopAppBarSectionScope: MDCTopAppBarSectionScope) {
    @Composable
    actual fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        mdcTopAppBarSectionScope.NavButton(attrs = { onClick { onClick() } }) { content() }

    @Composable
    actual fun MaterialIconNavButton(onClick: () -> Unit, materialIcon: MaterialIcon) =
        mdcTopAppBarSectionScope.NavButton(attrs = { mdcIcon() }) { org.jetbrains.compose.web.dom.Text(materialIcon.mdcIcon.type) }
}

actual class TopAppBarActionsScope(val mdcTopAppBarSectionScope: MDCTopAppBarSectionScope) {
    @Composable
    actual fun ActionButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        mdcTopAppBarSectionScope.ActionButton(attrs = { onClick { onClick() } }) { content() }

    @Composable
    actual fun MaterialIconActionButton(
        onClick: () -> Unit,
        materialIcon: MaterialIcon
    ) =
        mdcTopAppBarSectionScope.ActionButton(attrs = { mdcIcon() }) { org.jetbrains.compose.web.dom.Text(materialIcon.mdcIcon.type) }
}

@Composable
actual fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (NavigationIconScope.() -> Unit)?,
    actions: @Composable TopAppBarActionsScope.() -> Unit,
    content: @Composable () -> Unit
) =
    MDCTopAppBar {
        TopAppBar {
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
        Main { content() }
    }
