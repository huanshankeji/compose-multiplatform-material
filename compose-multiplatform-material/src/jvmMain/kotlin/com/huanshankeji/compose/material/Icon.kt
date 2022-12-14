package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual abstract class IconElement : Element()

@Composable
actual fun Icon(
    materialIcon: MaterialIcon, contentDescription: String?, modifierOrAttrs: ModifierOrAttrs<IconElement>
) =
    androidx.compose.material.Icon(materialIcon, contentDescription, modifierOrAttrs.toModifier())
