package com.huanshankeji.compose.layout

import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.width
import org.jetbrains.compose.web.css.percent

// TODO are there better values than `100.percent`?

@Stable
actual fun Modifier.width(intrinsicSize: IntrinsicSize): Modifier =
    platformModify { width(100.percent) }

@Stable
actual fun Modifier.height(intrinsicSize: IntrinsicSize): Modifier =
    platformModify { width(100.percent) }
