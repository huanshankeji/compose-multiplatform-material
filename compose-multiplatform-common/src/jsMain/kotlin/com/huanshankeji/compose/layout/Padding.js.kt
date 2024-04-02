package com.huanshankeji.compose.layout

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.toPx
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.paddingInline

@Stable
actual fun Modifier.padding(start: Dp, top: Dp, end: Dp, bottom: Dp): Modifier =
    platformModify {
        paddingInline(start.toPx(), end.toPx())
            .padding {
                top(top.toPx())
                bottom(bottom.toPx())
            }
    }

@Stable
actual fun Modifier.padding(horizontal: Dp, vertical: Dp): Modifier =
    platformModify { padding(vertical.toPx(), horizontal.toPx()) }

@Stable
actual fun Modifier.padding(all: Dp): Modifier =
    platformModify { padding(all.toPx()) }

@Stable
actual fun Modifier.absolutePadding(left: Dp, top: Dp, right: Dp, bottom: Dp): Modifier =
    platformModify { padding(top.toPx(), right.toPx(), bottom.toPx(), left.toPx()) }
