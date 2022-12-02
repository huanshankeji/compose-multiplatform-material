package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.top.app.bar.*
import org.w3c.dom.HTMLButtonElement

actual class ButtonScope(val mdcButtonScope: MDCButtonScope<HTMLButtonElement>) {
    @Composable
    actual fun Label(text: String) =
        mdcButtonScope.Label(text)
}

@Composable
actual fun Button(onClick: () -> Unit, content: @Composable ButtonScope.() -> Unit) =
    MDCButton(attrs = { onClick { onClick() } }) { ButtonScope(this).content() }


@Composable
actual fun TopAppBarScaffold(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)?,
    actions: @Composable () -> Unit,
    content: @Composable () -> Unit
) =
    MDCTopAppBar {
        TopAppBar {
            Row {
                Section(align = MDCTopAppBarSectionAlign.Start) {
                    navigationIcon?.let { NavButton { it() } }
                    Title { title() }
                }
                Section(
                    align = MDCTopAppBarSectionAlign.End,
                    attrs = {
                        attr("role", "toolbar")
                    }
                ) {
                    actions()
                }
            }
        }
        Main { content() }
    }
