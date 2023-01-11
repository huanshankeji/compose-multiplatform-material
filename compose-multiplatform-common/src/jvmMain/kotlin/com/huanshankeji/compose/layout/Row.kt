package com.huanshankeji.compose.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.StyleScope
import com.huanshankeji.compose.ui.toModifier

actual abstract class RowElement : Element()
actual class RowScope(val platformRowScope: androidx.compose.foundation.layout.RowScope) : LinearLayoutScope {
    override fun StyleScope.weight(weight: Float) = modify {
        with(platformRowScope) { weight(weight) }
    }
}

@Composable
actual fun Row(modifierOrAttrs: ModifierOrAttrs<RowElement>, content: @Composable RowScope.() -> Unit) =
    androidx.compose.foundation.layout.Row(modifierOrAttrs.toModifier()) {
        RowScope(this).content()
    }
