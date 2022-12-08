package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.Text
import com.huanshankeji.compose.material.Button
import com.huanshankeji.compose.material.Card
import com.huanshankeji.compose.material.TopAppBarScaffold
import com.huanshankeji.compose.material.icon.MaterialIcons

@Composable
fun App() {
    TopAppBarScaffold({
        Text("Compose Multiplatform Material demo")
    }, {
        MaterialIconNavButton({}, MaterialIcons.Menu)
    }, {
        MaterialIconActionButton({}, MaterialIcons.Search)
    }) {
        Card {
            var count by remember { mutableStateOf(0) }
            Button({ count++ }) {
                Label(count.toString())
            }
        }
    }
}
