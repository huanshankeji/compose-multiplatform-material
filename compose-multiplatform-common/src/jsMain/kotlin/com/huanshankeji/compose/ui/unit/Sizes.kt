package com.huanshankeji.compose.ui.unit

import org.jetbrains.compose.web.css.*

actual sealed interface LengthOrPercentage {
    val platformValue: CSSLengthOrPercentageValue

    class Impl(override val platformValue: CSSLengthOrPercentageValue) : LengthOrPercentage
}

actual sealed interface Length : LengthOrPercentage {
    override val platformValue: CSSLengthValue

    class Impl(override val platformValue: CSSLengthValue) : Length
}

// JS only
class Percentage(override val platformValue: CSSPercentageValue) : LengthOrPercentage


actual class DpOrPx(override val platformValue: CSSpxValue) : Length

actual val Int.dpOrPx: DpOrPx
    get() = DpOrPx(this.px)
