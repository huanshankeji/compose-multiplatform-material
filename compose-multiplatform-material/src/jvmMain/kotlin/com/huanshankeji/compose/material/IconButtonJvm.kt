package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual abstract class IconButtonElement : Element()

@Composable
actual fun IconButton(
    onClick: () -> Unit,
    modifierOrAttrs: ModifierOrAttrs<IconButtonElement>,
    content: @Composable () -> Unit
) =
    androidx.compose.material.IconButton(onClick, modifierOrAttrs.toModifier(), content = content)
