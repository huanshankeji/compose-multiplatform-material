package com.huanshankeji.compose.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

actual typealias ColumnElement = HTMLDivElement

actual interface ColumnScope {
    val elementScope: ElementScope<HTMLDivElement>

    class Impl(override val elementScope: ElementScope<HTMLDivElement>) : ColumnScope
}

@Composable
actual fun Column(modifierOrAttrs: ModifierOrAttrs<ColumnElement>, content: @Composable ColumnScope.() -> Unit) =
    // TODO: `modifierOrAttrs` not used yet
    com.huanshankeji.compose.web.Column {
        ColumnScope.Impl(this).content()
    }
