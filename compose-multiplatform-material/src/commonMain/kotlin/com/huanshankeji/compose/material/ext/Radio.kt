package com.huanshankeji.compose.material.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

// TODO colors
@Composable
expect fun RadioRow(
    selected: Boolean,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
)

@Composable
expect fun RadioGroupRow(modifier: Modifier = Modifier, content: @Composable () -> Unit)

// TODO `RadioGroupColumn`
