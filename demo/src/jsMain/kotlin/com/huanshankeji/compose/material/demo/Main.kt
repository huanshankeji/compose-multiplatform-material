package com.huanshankeji.compose.material.demo

import com.huanshankeji.compose.html.material3.require
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    require("material-symbols/outlined.css")
    renderComposableInBody { App() }
}
