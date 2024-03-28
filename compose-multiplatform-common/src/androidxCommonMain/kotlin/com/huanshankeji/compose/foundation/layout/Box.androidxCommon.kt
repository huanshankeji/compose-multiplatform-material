package com.huanshankeji.compose.foundation.layout

import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.PlatformWrapperInterface
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import androidx.compose.foundation.layout.Box as PlatformBox
import androidx.compose.foundation.layout.BoxScope as PlatformBoxScope

@Composable
actual fun Box(
    modifier: Modifier,
    contentAlignment: Alignment,
    content: @Composable BoxScope.() -> Unit
) =
    PlatformBox(
        modifier.platformModifier,
        contentAlignment.platformAlignment,
    ) { BoxScope.Impl(this).content() }

/*
@Composable
actual fun Box(modifier: Modifier) =
    PlatformBox(modifier.platformModifier)
*/

@LayoutScopeMarker
@Immutable
actual interface BoxScope : PlatformWrapperInterface<PlatformBoxScope> {
    class Impl(platformValue: PlatformBoxScope) : BoxScope,
        PlatformWrapperInterface.Impl<PlatformBoxScope>(platformValue)

    @Stable
    actual fun Modifier.align(alignment: Alignment): Modifier =
        with(platformValue) { platformModify { align(alignment.platformAlignment) } }
}
