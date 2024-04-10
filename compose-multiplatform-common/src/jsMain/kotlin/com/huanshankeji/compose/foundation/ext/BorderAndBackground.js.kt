package com.huanshankeji.compose.foundation.ext

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.foundation.BorderStroke
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.graphics.Color

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    border: BorderStroke, cornerRadius: Dp, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(border, cornerRadius).background(backgroundColor)

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    border: BorderStroke, cornerRadiusPercent: Int, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(border, cornerRadiusPercent).background(backgroundColor)

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    width: Dp, borderColor: Color, cornerRadius: Dp, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(width, borderColor, cornerRadius).background(backgroundColor)

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    width: Dp, borderColor: Color, cornerRadiusPercent: Int, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(width, borderColor, cornerRadiusPercent).background(backgroundColor)
