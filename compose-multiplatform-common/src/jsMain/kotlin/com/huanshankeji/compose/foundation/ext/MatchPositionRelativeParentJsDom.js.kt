package com.huanshankeji.compose.foundation.ext

import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import org.jetbrains.compose.web.css.*

actual fun Modifier.matchPositionRelativeParentJsOnly(): Modifier =
    platformModify {
        attrsModifier {
            style {
                position(Position.Absolute)
                left(0.px)
                top(0.px)
                right(0.px)
                bottom(0.px)
                // Also considering using `inset` (https://developer.mozilla.org/en-US/docs/Web/CSS/inset)
            }
        }
    }
