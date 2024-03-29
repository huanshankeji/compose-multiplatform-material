package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.foundation.layout.LayoutScopeMarker
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope as PlatformColumnScope

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScope.() -> Unit
) =
    com.varabyte.kobweb.compose.foundation.layout.Column(
        modifier.platformModifier,
        verticalArrangement.platformValue,
        horizontalAlignment.platformValue
    ) { ColumnScope.Impl(this).content() }

@LayoutScopeMarker
actual interface ColumnScope {
    val platformValue: PlatformColumnScope

    value class Impl(override val platformValue: PlatformColumnScope) : ColumnScope

    @Stable
    actual fun Modifier.align(alignment: Alignment.Horizontal): Modifier =
        with(platformValue) { platformModify { align(alignment.platformValue) } }
}
