package com.huanshankeji.compose.material2.icons

import com.huanshankeji.compose.material.icons.Icon
import dev.petuska.kmdcx.icons.MDCIcon

val mdcIconMap = MDCIcon.entries.associateBy { it.type }

fun Icon.toMDCIcon() =
    mdcIconMap.getValue(name)
