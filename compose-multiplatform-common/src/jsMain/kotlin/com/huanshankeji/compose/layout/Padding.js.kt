package com.huanshankeji.compose.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.toPx
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.marginInline

@Stable
actual fun Modifier.padding(start: Dp, top: Dp, end: Dp, bottom: Dp): Modifier =
    platformModify {
        marginInline(start.toPx(), end.toPx())
            .margin {
                top(top.toPx())
                bottom(bottom.toPx())
            }
    }

@Stable
actual fun Modifier.padding(horizontal: Dp, vertical: Dp): Modifier =
    platformModify { margin(vertical.toPx(), horizontal.toPx()) }

@Stable
actual fun Modifier.padding(all: Dp): Modifier =
    platformModify { margin(all.toPx()) }

@Stable
actual fun Modifier.absolutePadding(left: Dp, top: Dp, right: Dp, bottom: Dp): Modifier =
    platformModify { margin(top.toPx(), right.toPx(), bottom.toPx(), left.toPx()) }
