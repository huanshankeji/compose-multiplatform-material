package com.huanshankeji.compose.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.StyleScope
import com.huanshankeji.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

actual typealias RowElement = HTMLDivElement

actual class RowScope(val elementScope: ElementScope<HTMLDivElement>) : LinearLayoutScope {
    override fun StyleScope.weight(weight: Float) =
        weightInternal(weight)
}

@Composable
actual fun Row(modifierOrAttrs: ModifierOrAttrs<RowElement>, content: @Composable RowScope.() -> Unit) =
    com.huanshankeji.compose.web.Row(modifierOrAttrs.toAttrs()) {
        RowScope(this).content()
    }
