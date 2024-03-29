package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.foundation.layout.LayoutScopeMarker
import com.varabyte.kobweb.compose.foundation.layout.BoxScope as PlatformBoxScope

@Composable
actual fun Box(
    modifier: Modifier,
    contentAlignment: Alignment,
    content: @Composable BoxScope.() -> Unit
) =
    com.varabyte.kobweb.compose.foundation.layout.Box(
        modifier.platformModifier,
        contentAlignment.platformValue,
    ) { BoxScope.Impl(this).content() }

@LayoutScopeMarker
@Immutable
actual interface BoxScope {
    val platformBoxScope: PlatformBoxScope

    value class Impl(override val platformBoxScope: PlatformBoxScope) : BoxScope

    @Stable
    actual fun Modifier.align(alignment: Alignment): Modifier =
        with(platformBoxScope) { platformModify { align(alignment.platformValue) } }
}
