package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon
import dev.petuska.kmdcx.icons.MDCIconSpan

/**
 * There is often a better alternative of adding the CSS rule to the parent element to using this composable directly.
 */
@Composable
actual fun Icon(materialIcon: MaterialIcon) =
    MDCIconSpan(materialIcon.mdcIcon)
