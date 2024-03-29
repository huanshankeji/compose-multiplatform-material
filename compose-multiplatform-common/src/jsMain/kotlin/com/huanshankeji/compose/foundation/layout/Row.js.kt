package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.foundation.layout.LayoutScopeMarker
import com.varabyte.kobweb.compose.foundation.layout.RowScope as PlatformRowScope

@Composable
actual fun Row(
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal,
    verticalAlignment: Alignment.Vertical,
    content: @Composable RowScope.() -> Unit
) =
    com.varabyte.kobweb.compose.foundation.layout.Row(
        modifier.platformModifier,
        horizontalArrangement.platformValue,
        verticalAlignment.platformValue
    ) { RowScope.Impl(this).content() }

@LayoutScopeMarker
actual interface RowScope {
    val platformValue: PlatformRowScope

    value class Impl(override val platformValue: PlatformRowScope) : RowScope

    @Stable
    actual fun Modifier.align(alignment: Alignment.Vertical): Modifier =
        with(platformValue) { platformModify { align(alignment.platformValue) } }
}
