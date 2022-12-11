package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.BasicText
import com.huanshankeji.compose.layout.Box
import com.huanshankeji.compose.material.*
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
                val onClick: () -> Unit = { count++ }
                Button(onClick) {
                    Label(count.toString())
                }

                IconButton(onClick, materialIcon = MaterialIcons.Search)

                List {
                    item {
                        Text("Ungrouped item")
                    }
                    items(count) {
                        Text("Ungrouped item $it/$count")
                    }
                    group(headerContent = {
                        Text("Group title")
                    }) {
                        item {
                            Text("Grouped item")
                        }
                        items(count) {
                            Text("Grouped item $it/$count")
                        }
                    }
                }
            }
        }
    }
}
