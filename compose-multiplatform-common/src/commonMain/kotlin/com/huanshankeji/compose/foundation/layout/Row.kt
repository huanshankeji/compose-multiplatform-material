package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier

@Composable
expect fun Row(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit
)

//@LayoutScopeMarker
expect interface RowScope {
    @Stable
    open fun Modifier.align(alignment: Alignment.Vertical): Modifier
}
