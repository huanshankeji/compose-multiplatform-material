package com.huanshankeji.compose.layout

import com.huanshankeji.compose.ui.StyleScope

interface LinearLayoutScope {
    // TODO: its implementations are currently visually inconsistent on desktop/Android and web
    @Deprecated("This function is currently visually inconsistent on desktop/Android and web.")
    fun StyleScope.weight(weight: Float)
}
