package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

@Composable
actual fun RadioButton(selected: Boolean, onClick: (() -> Unit)?, modifier: Modifier, enabled: Boolean) =
    androidx.compose.material.RadioButton(selected, onClick, enabled = enabled)
