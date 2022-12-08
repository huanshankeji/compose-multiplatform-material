package com.huanshankeji.compose.ui.unit

import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

actual abstract class SizeValue(val platformValue: CSSLengthOrPercentageValue)
actual class DpOrPxValue(platformValue: CSSSizeValue<CSSUnit.px>) : SizeValue(platformValue)

actual val Int.dpOrPx: DpOrPxValue
    get() = DpOrPxValue(this.px)
