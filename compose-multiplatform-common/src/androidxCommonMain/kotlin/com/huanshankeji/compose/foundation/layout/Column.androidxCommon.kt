package com.huanshankeji.compose.foundation.layout

import androidx.annotation.FloatRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import kotlin.jvm.JvmInline
import androidx.compose.foundation.layout.ColumnScope as PlatformColumnScope

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScope.() -> Unit
) =
    androidx.compose.foundation.layout.Column(
        modifier.platformModifier,
        verticalArrangement.platformValue,
        horizontalAlignment.platformHorizontal,
    ) { ColumnScope.Impl(this).content() }

//@LayoutScopeMarker
actual interface ColumnScope {
    val platformValue: PlatformColumnScope

    @JvmInline
    value class Impl(override val platformValue: PlatformColumnScope) : ColumnScope

    @Stable
    actual fun Modifier.weight(
        @FloatRange(from = 0.0, fromInclusive = false)
        weight: Float
    ): Modifier =
        with(platformValue) { platformModify { weight(weight) } }

    @Stable
    actual fun Modifier.align(alignment: Alignment.Horizontal): Modifier =
        with(platformValue) { platformModify { align(alignment.platformHorizontal) } }
}
