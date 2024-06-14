package com.huanshankeji.androidx.navigation.compose.bug

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(::exitApplication) {
        App()
    }
}
