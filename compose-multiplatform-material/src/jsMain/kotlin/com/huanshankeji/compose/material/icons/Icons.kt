package com.huanshankeji.compose.material.icons

import dev.petuska.kmdcx.icons.MDCIcon

actual class IconType(val mdcIcon: MDCIcon)

actual object Icons {
    actual val Search: IconType = IconType(MDCIcon.Search)
}
