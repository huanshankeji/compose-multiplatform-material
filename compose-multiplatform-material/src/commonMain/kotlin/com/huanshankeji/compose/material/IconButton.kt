package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class IconButtonElement : Element

@Composable
expect fun IconButton(
    onClick: () -> Unit,
    modifierOrAttrs: ModifierOrAttrs<IconButtonElement> = null,
    content: @Composable () -> Unit
)


@Composable
fun IconButton(
    onClick: () -> Unit,
    modifierOrAttrs: ModifierOrAttrs<IconButtonElement> = null,
    materialIcon: MaterialIcon,
    contentDescription: String?
) =
    IconButton(onClick, modifierOrAttrs) { Icon(materialIcon, contentDescription) }
