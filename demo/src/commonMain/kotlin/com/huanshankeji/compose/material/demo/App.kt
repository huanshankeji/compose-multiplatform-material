package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.rememberScrollState
import com.huanshankeji.compose.foundation.verticalScroll
import com.huanshankeji.compose.layout.padding
import com.huanshankeji.compose.ui.Modifier

internal enum class Selection {
    A, B, C
}

val listSize = 160.dp

fun Modifier.contentPadding() = padding(16.dp)
val contentPaddingModifier = Modifier.contentPadding()

@Composable
fun App() {
    Row {
        @Composable
        fun subDemoModifier() =
            Modifier.weight(1f).verticalScroll(rememberScrollState())

        Common(subDemoModifier())
        // Putting the scroll modifier in the `Box` causes `java.lang.IllegalArgumentException: Can't represent a size of 2147483577 in Constraints`.
        Box(Modifier.weight(1f)) {
            Material2(Modifier.verticalScroll(rememberScrollState()))
        }
        Material3(subDemoModifier())
    }
}
