package com.huanshankeji.compose.layout

import com.huanshankeji.compose.ui.StyleScope
import org.jetbrains.compose.web.css.flexGrow

internal fun StyleScope.weightInternal(weight: Float) =
    cssStyleScope.flexGrow(weight)
