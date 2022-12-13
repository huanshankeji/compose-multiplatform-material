package com.huanshankeji.compose.material.icon

import dev.petuska.kmdcx.icons.MDCIcon

actual class MaterialIcon(val mdcIcon: MDCIcon)

actual object MaterialIcons {
    actual val Add = MaterialIcon(MDCIcon.Add)
    actual val Menu = MaterialIcon(MDCIcon.Menu)
    actual val Search = MaterialIcon(MDCIcon.Search)
}
