package com.huanshankeji.compose.material2.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.contentDescription
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.layout.fillMaxSize
import com.huanshankeji.compose.layout.fillMaxWidth
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.material2.icons.mdcIconWithStyle
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.toAttrs
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.textAlign
import dev.petuska.kmdc.top.app.bar.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

actual class NavigationIconScope(val mdcTopAppBarSectionScope: MDCTopAppBarSectionScope) {
    @Composable
    actual fun NavButton(onClick: () -> Unit, modifier: Modifier, content: @Composable () -> Unit) =
        mdcTopAppBarSectionScope.NavButton(attrs = modifier.toAttrs { onClick { onClick() } }) { content() }

    @Composable
    actual fun MaterialIconNavButton(onClick: () -> Unit, modifier: Modifier, icon: Icon, contentDescription: String?) =
        mdcTopAppBarSectionScope.NavButton(attrs = modifier.toAttrs {
            onClick { onClick() }
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
    floatingActionButton: @Composable (() -> Unit)?,
    floatingActionButtonPosition: FabPosition,
    isFloatingActionButtonDockedAndroidxCommon: Boolean,
    content: @Composable () -> Unit
) {
    @Composable
    fun fabWithPosition(floatingActionButton: @Composable (() -> Unit)) =
        Div({
            style {
                position(Position.Absolute)
                bottom(16.px)
                when (floatingActionButtonPosition) {
                    FabPosition.Start -> left(16.px)
                    FabPosition.Center -> {
                        width(100.percent)
                        textAlign(TextAlign.Center)
                    }

                    FabPosition.End -> right(16.px)
                }
            }
        }) {
            floatingActionButton()
        }

    Column(Modifier.fillMaxSize()) {
        Div(Modifier.weight(1f).fillMaxWidth().toAttrs {
            style { position(Position.Relative) }
        }) {
            PrimitiveTopAppBarScaffold(
                title,
                topAppBarModifier,
                navigationIcon,
                actions,
                Modifier,
                content
            )
            floatingActionButton?.let { fabWithPosition(it) }
        }

        bottomBar?.invoke()
    }
    snackbarHost?.let { it() }
}
