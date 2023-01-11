package com.huanshankeji.compose.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class RowElement : Element
expect class RowScope : LinearLayoutScope

@Composable
expect fun Row(modifierOrAttrs: ModifierOrAttrs<RowElement> = null, content: @Composable RowScope.() -> Unit)
