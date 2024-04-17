package com.huanshankeji.kobweb.compose.ui.modifiers

import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width

fun Modifier.size(width: Width, height: Height): Modifier =
    /*
    // not working
    styleModifier {
        width(width)
        height(height)
    }
    */
    width(width).height(height)


fun Modifier.sizeFitContent() =
    size(Width.FitContent, Height.FitContent)
