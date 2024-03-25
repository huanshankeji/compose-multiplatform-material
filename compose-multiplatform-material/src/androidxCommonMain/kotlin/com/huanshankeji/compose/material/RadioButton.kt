package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

@Composable
actual fun RadioButton(selected: Boolean, onClick: (() -> Unit)?, enabled: Boolean) =
    androidx.compose.material.RadioButton(selected, onClick, enabled = enabled)
