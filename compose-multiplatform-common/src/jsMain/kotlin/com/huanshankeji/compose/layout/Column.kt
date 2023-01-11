package com.huanshankeji.compose.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.StyleScope
import com.huanshankeji.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

actual typealias ColumnElement = HTMLDivElement

actual class ColumnScope(val elementScope: ElementScope<HTMLDivElement>) : LinearLayoutScope {
    override fun StyleScope.weight(weight: Float) =
        weightInternal(weight)
}

@Composable
actual fun Column(modifierOrAttrs: ModifierOrAttrs<ColumnElement>, content: @Composable ColumnScope.() -> Unit) =
    com.huanshankeji.compose.web.Column(modifierOrAttrs.toAttrs()) {
        ColumnScope(this).content()
    }
