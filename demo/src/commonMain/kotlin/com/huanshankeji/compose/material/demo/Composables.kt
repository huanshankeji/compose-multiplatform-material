package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.BasicText
import com.huanshankeji.compose.layout.Box
import com.huanshankeji.compose.layout.Column
import com.huanshankeji.compose.layout.Row
import com.huanshankeji.compose.material.*
import com.huanshankeji.compose.material.icon.MaterialIcons
import com.huanshankeji.compose.ui.unit.dpOrPx

@OptIn(ConfusableTextApi::class)
@Composable
fun App() {
    TopAppBarScaffold({
        Text("Compose Multiplatform Material demo")
    }, {
        MaterialIconNavButton({}, MaterialIcons.Menu, "menu")
    }, {
        MaterialIconActionButton({}, MaterialIcons.Search, "search")
    }) {
        Card({
            style {
                margin(16.dpOrPx)
            }
        }) {
            Column {
                BasicText("basic text")
                Text("Material text")

                var count by remember { mutableStateOf(0) }
                val onClick: () -> Unit = { count++ }

                Row {
                    Button(onClick) {
                        Label(count.toString())
                    }
                    IconButton(onClick, materialIcon = MaterialIcons.Add, contentDescription = "increment count")
                }

                Box({
                    style {
                        margin(16.dpOrPx)
                    }
                }) {
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
}
