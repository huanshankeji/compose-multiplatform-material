package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.BasicText
import com.huanshankeji.compose.layout.Box
import com.huanshankeji.compose.material.Button
import com.huanshankeji.compose.material.Card
import com.huanshankeji.compose.material.Text
import com.huanshankeji.compose.material.TopAppBarScaffold
import com.huanshankeji.compose.material.icon.MaterialIcons
import com.huanshankeji.compose.ui.unit.dpOrPx

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
            Box({
                style {
                    padding(16.dpOrPx)
                }
            }) {
                BasicText("basic text")
                Text("Material text")

                var count by remember { mutableStateOf(0) }
                Button({ count++ }) {
                    Label(count.toString())
                }
            }
        }
    }
}
