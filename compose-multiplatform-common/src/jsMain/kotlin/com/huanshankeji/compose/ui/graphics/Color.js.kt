package com.huanshankeji.compose.ui.graphics

import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import org.jetbrains.compose.web.css.CSSColorValue
import com.varabyte.kobweb.compose.ui.graphics.Color as KobwebColor
import com.varabyte.kobweb.compose.ui.graphics.Colors as KobwebColors
import org.jetbrains.compose.web.css.Color as ComposeHtmlColor


@Immutable
actual /*value*/ class Color(val platformValue: CSSColorValue) {
    actual override fun toString(): String =
        platformValue.toString()

    actual companion object {
        @Stable
        actual val Black: Color = Color(ComposeHtmlColor.black)

        // TODO refactor the following

        @Stable
        actual val DarkGray: Color = Color(KobwebColors.DarkGray)

        @Stable
        actual val Gray: Color = Color(KobwebColors.Gray)

        @Stable
        actual val LightGray: Color = Color(KobwebColors.LightGray)

        @Stable
        actual val White: Color = Color(KobwebColors.White)

        @Stable
        actual val Red: Color = Color(KobwebColors.Red)

        @Stable
        actual val Green: Color = Color(KobwebColors.Green)

        @Stable
        actual val Blue: Color = Color(KobwebColors.Blue)

        @Stable
        actual val Yellow: Color = Color(KobwebColors.Yellow)

        @Stable
        actual val Cyan: Color = Color(KobwebColors.Cyan)

        @Stable
        actual val Magenta: Color = Color(KobwebColors.Magenta)

        @Stable
        actual val Transparent: Color = Color(KobwebColors.Transparent)

        actual fun hsl(
            hue: Float,
            saturation: Float,
            lightness: Float,
            alpha: Float
        ): Color =
            Color(KobwebColor.hsla(hue, saturation, lightness, alpha))
    }
}

@Stable
actual fun Color(red: Float, green: Float, blue: Float, alpha: Float): Color =
    Color(KobwebColor.rgba(red, green, blue, alpha))

@Stable
actual fun Color(@ColorInt color: Int): Color =
    Color(KobwebColor.argb(color))

@Stable
actual fun Color(color: Long): Color =
    Color(KobwebColor.argb(color))

@Stable
actual fun Color(
    @IntRange(from = 0, to = 0xFF) red: Int,
    @IntRange(from = 0, to = 0xFF) green: Int,
    @IntRange(from = 0, to = 0xFF) blue: Int,
    @IntRange(from = 0, to = 0xFF) alpha: Int
): Color =
    Color(KobwebColor.rgba(red, green, blue, alpha))

@Stable
actual fun Color.luminance(): Float =
    //platformValue.luminance
    TODO()

@ColorInt
@Stable
actual fun Color.toArgb(): Int =
    //platformValue.toRgb().value
    TODO()
