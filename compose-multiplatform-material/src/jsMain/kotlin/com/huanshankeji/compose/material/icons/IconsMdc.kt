package com.huanshankeji.compose.material.icons

import dev.petuska.kmdcx.icons.MDCIcon

val mdcIconMap = MDCIcon.entries.associateBy { it.type }

fun Icon.toMDCIcon() =
    mdcIconMap.getValue(name)
