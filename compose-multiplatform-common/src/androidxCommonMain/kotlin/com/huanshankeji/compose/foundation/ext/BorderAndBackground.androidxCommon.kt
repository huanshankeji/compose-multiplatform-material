package com.huanshankeji.compose.foundation.ext

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.huanshankeji.compose.foundation.BorderStroke
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.graphics.Color

private fun Modifier.roundedCornerBackground(color: Color, cornerRadius: Dp) =
    platformModify {
        background(color.platformValue, RoundedCornerShape(cornerRadius))
    }


private fun Modifier.roundedCornerBackground(color: Color, cornerRadiusPercent: Int) =
    platformModify {
        background(color.platformValue, RoundedCornerShape(cornerRadiusPercent))
    }

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    border: BorderStroke, cornerRadius: Dp, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(border, cornerRadius).roundedCornerBackground(backgroundColor, cornerRadius)

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    border: BorderStroke, cornerRadiusPercent: Int, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(border, cornerRadiusPercent).roundedCornerBackground(backgroundColor, cornerRadiusPercent)

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    width: Dp, borderColor: Color, cornerRadius: Dp, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(width, borderColor, cornerRadius).roundedCornerBackground(backgroundColor, cornerRadius)

@Stable
actual fun Modifier.roundedCornerOuterBorderAndBackground(
    width: Dp, borderColor: Color, cornerRadiusPercent: Int, backgroundColor: Color
): Modifier =
    roundedCornerOuterBorder(width, borderColor, cornerRadiusPercent)
        .roundedCornerBackground(backgroundColor, cornerRadiusPercent)
