package com.huanshankeji.compose.material.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

actual fun main() = application {
    Window(::exitApplication) {
        App()
    }
}
