package com.huanshankeji.compose.foundation.layout

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun Spacer(modifier: Modifier) {
    AddKobwebComposeStyleSheet()
    Div(attrs = modifier.platformModifier.toAttrs { classes("kobweb-spacer") })
    //com.varabyte.kobweb.compose.foundation.layout.Spacer() // use this when `Modifier` is supported
}
