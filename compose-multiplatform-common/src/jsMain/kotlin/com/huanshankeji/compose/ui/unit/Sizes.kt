package com.huanshankeji.compose.ui.unit

import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

actual abstract class NumericSize(val platformValue: CSSLengthOrPercentageValue)
actual class DpOrPx(platformValue: CSSSizeValue<CSSUnit.px>) : NumericSize(platformValue)

actual val Int.dpOrPx: DpOrPx
    get() = DpOrPx(this.px)
