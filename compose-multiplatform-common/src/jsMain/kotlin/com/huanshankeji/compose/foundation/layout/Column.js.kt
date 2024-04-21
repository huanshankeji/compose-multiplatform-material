package com.huanshankeji.compose.foundation.layout

import androidx.annotation.FloatRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.kobweb.compose.ui.modifiers.sizeFitContent
import com.varabyte.kobweb.compose.foundation.layout.LayoutScopeMarker
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope as PlatformColumnScope
import com.varabyte.kobweb.compose.ui.Modifier as PlatformModifier

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable ColumnScope.() -> Unit
) =
    com.varabyte.kobweb.compose.foundation.layout.Column(
        PlatformModifier.display(DisplayStyle.Flex).flexDirection(FlexDirection.Column)
            .sizeFitContent() // "fit-content" is added to make it consistent with the `androidx` one
            .then(modifier.platformModifier),
        verticalArrangement.platformValue,
        horizontalAlignment.platformValue
    ) { ColumnScope.Impl(this).content() }

@LayoutScopeMarker
actual interface ColumnScope {
    val platformValue: PlatformColumnScope

    value class Impl(override val platformValue: PlatformColumnScope) : ColumnScope

    @Stable
    actual fun Modifier.weight(
        @FloatRange(from = 0.0, fromInclusive = false)
        weight: Float
    ): Modifier =
        with(platformValue) { platformModify { weight(weight) } }

    @Stable
    actual fun Modifier.align(alignment: Alignment.Horizontal): Modifier =
        with(platformValue) { platformModify { align(alignment.platformValue) } }
}
