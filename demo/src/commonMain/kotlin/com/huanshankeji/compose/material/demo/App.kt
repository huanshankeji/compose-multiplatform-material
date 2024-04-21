package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.text.BasicText
import com.huanshankeji.compose.ui.Modifier

internal enum class RadioButtonState {
    A, B, C
}

@Composable
fun App() {
    Column {
        BasicText("basic text 1")
        BasicText("basic text 2")
        Row {
            Box(Modifier.weight(1f)) {
                Material2()
            }
            Box(Modifier.weight(1f)) {
                Material3()
            }
        }
    }
}
