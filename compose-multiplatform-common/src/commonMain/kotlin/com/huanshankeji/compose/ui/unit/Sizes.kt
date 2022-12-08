package com.huanshankeji.compose.ui.unit

expect abstract class SizeValue
expect class DpOrPxValue : SizeValue

expect val Int.dpOrPx: DpOrPxValue
