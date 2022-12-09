package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icon.MaterialIcon

@Composable
actual fun Icon(materialIcon: MaterialIcon) =
    androidx.compose.material.Icon(materialIcon, null)
// no `contentDescription` for now
