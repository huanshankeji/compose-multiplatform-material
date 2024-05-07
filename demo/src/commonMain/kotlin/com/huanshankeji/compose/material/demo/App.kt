package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.ui.Modifier

internal enum class RadioButtonState {
    A, B, C
}

val listSize = 160.dp

@Composable
fun App() {
    Row {
        Box(Modifier.weight(1f)) {
            Common()
        }
        Box(Modifier.weight(1f)) {
            Material2()
        }
        Box(Modifier.weight(1f)) {
            Material3()
        }
    }
}
