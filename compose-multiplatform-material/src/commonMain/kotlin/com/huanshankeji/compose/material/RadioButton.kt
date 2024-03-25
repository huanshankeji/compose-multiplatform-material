package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable

// TODO modifier
// TODO colors
@Composable
expect fun RadioButton(selected: Boolean, onClick: (() -> Unit)?, enabled: Boolean = true)
