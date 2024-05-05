package com.huanshankeji.compose.foundation.layout

import androidx.annotation.FloatRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.kobweb.compose.ui.modifiers.sizeFitContent
import com.varabyte.kobweb.compose.foundation.layout.LayoutScopeMarker
import com.varabyte.kobweb.compose.foundation.layout.RowScope as PlatformRowScope
import com.varabyte.kobweb.compose.ui.Modifier as PlatformModifier

@Composable
actual fun Row(
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal,
    verticalAlignment: Alignment.Vertical,
    content: @Composable RowScope.() -> Unit
) {
    AddKobwebComposeStyleSheet()
    com.varabyte.kobweb.compose.foundation.layout.Row(
        PlatformModifier
            .sizeFitContent()
            .then(modifier.platformModifier),
        horizontalArrangement.platformValue,
        verticalAlignment.platformValue,
        content = content.toPlatformRowScopeContent()
    )
}

@LayoutScopeMarker
actual interface RowScope {
    val platformValue: PlatformRowScope

    value class Impl(override val platformValue: PlatformRowScope) : RowScope

    @Stable
    actual fun Modifier.weight(
        @FloatRange(from = 0.0, fromInclusive = false)
        weight: Float
    ): Modifier =
        with(platformValue) { platformModify { weight(weight) } }

    @Stable
    actual fun Modifier.align(alignment: Alignment.Vertical): Modifier =
        with(platformValue) { platformModify { align(alignment.platformValue) } }
}


fun (@Composable (RowScope.() -> Unit)).toPlatformRowScopeContent(): @Composable PlatformRowScope.() -> Unit =
    { RowScope.Impl(this).(this@toPlatformRowScopeContent)() }
