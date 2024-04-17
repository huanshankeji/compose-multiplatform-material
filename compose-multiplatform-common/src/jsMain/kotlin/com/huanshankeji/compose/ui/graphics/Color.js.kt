package com.huanshankeji.compose.ui.graphics

import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.ui.graphics.luminance
import com.varabyte.kobweb.compose.ui.graphics.Color as PlatformColor
import com.varabyte.kobweb.compose.ui.graphics.Colors as PlatformColors

@Immutable
actual /*value*/ class Color(val platformValue: PlatformColor) {
    actual override fun toString(): String =
        platformValue.toString()

    actual companion object {
        @Stable
        actual val Black: Color = Color(PlatformColors.Black)

        @Stable
        actual val DarkGray: Color = Color(PlatformColors.DarkGray)

        @Stable
        actual val Gray: Color = Color(PlatformColors.Gray)

        @Stable
        actual val LightGray: Color = Color(PlatformColors.LightGray)

        @Stable
        actual val White: Color = Color(PlatformColors.White)

        @Stable
        actual val Red: Color = Color(PlatformColors.Red)

        @Stable
        actual val Green: Color = Color(PlatformColors.Green)

        @Stable
        actual val Blue: Color = Color(PlatformColors.Blue)

        @Stable
        actual val Yellow: Color = Color(PlatformColors.Yellow)

        @Stable
        actual val Cyan: Color = Color(PlatformColors.Cyan)

        @Stable
        actual val Magenta: Color = Color(PlatformColors.Magenta)

        @Stable
        actual val Transparent: Color = Color(PlatformColors.Transparent)

        actual fun hsl(
            hue: Float,
            saturation: Float,
            lightness: Float,
            alpha: Float
        ): Color =
            Color(PlatformColor.hsla(hue, saturation, lightness, alpha))
    }
}

@Stable
actual fun Color(red: Float, green: Float, blue: Float, alpha: Float): Color =
    Color(PlatformColor.rgba(red, green, blue, alpha))

@Stable
actual fun Color(@ColorInt color: Int): Color =
    Color(PlatformColor.argb(color))

@Stable
actual fun Color(color: Long): Color =
    Color(PlatformColor.argb(color))

@Stable
actual fun Color(
    @IntRange(from = 0, to = 0xFF) red: Int,
    @IntRange(from = 0, to = 0xFF) green: Int,
    @IntRange(from = 0, to = 0xFF) blue: Int,
    @IntRange(from = 0, to = 0xFF) alpha: Int
): Color =
    Color(PlatformColor.rgba(red, green, blue, alpha))

@Stable
actual fun Color.luminance(): Float =
    platformValue.luminance

@ColorInt
@Stable
actual fun Color.toArgb(): Int =
    platformValue.toRgb().value
