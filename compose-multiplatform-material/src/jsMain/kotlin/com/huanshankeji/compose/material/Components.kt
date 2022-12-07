package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.top.app.bar.*
import dev.petuska.kmdcx.icons.MDCIconSpan
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

actual class ButtonScope(val mdcButtonScope: MDCButtonScope<HTMLButtonElement>) {
    @Composable
    actual fun Label(text: String) =
        mdcButtonScope.Label(text)
}

@Composable
actual fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit) =
    MDCButton(attrs = { onClick { onClick() } }) { ButtonScope(this).content() }


/**
 * There is often a better alternative of adding the CSS rule to the parent element to using this composable directly.
 */
@Composable
actual fun Icon(materialIcon: MaterialIcon) =
    MDCIconSpan(materialIcon.mdcIcon)


@Composable
actual fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit) =
    MDCIconButton(attrs = {
        onClick { onClick() }
    }) { content() }


actual class NavigationIconScope(val mdcTopAppBarSectionScope: MDCTopAppBarSectionScope) {
    @Composable
    actual fun NavButton(onClick: () -> Unit, content: @Composable () -> Unit) =
        mdcTopAppBarSectionScope.NavButton(attrs = { onClick { onClick() } }) { content() }

    @Composable
    actual fun MaterialIconNavButton(onClick: () -> Unit, materialIcon: MaterialIcon) =
        mdcTopAppBarSectionScope.NavButton(attrs = { mdcIcon() }) { Text(materialIcon.mdcIcon.type) }
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
        mdcTopAppBarSectionScope.ActionButton(attrs = { mdcIcon() }) { Text(materialIcon.mdcIcon.type) }
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
