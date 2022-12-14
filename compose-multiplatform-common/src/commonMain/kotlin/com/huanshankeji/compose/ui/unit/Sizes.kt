package com.huanshankeji.compose.ui.unit

expect abstract class NumericSize
expect class DpOrPx : NumericSize

expect val Int.dpOrPx: DpOrPx


sealed class Size {
    class Numeric(val value: NumericSize) : Size()
    object FillMax : Size()
    object FitContent : Size()
}
