package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class IconElement : Element

@Composable
expect fun Icon(materialIcon: MaterialIcon, modifierOrAttrs: ModifierOrAttrs<IconElement> = null)
