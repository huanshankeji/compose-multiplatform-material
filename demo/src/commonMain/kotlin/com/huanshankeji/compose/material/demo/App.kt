package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.BasicText
import com.huanshankeji.compose.layout.Box
import com.huanshankeji.compose.layout.Column
import com.huanshankeji.compose.layout.Row
import com.huanshankeji.compose.material.*
import com.huanshankeji.compose.material.icon.MaterialIcons
import com.huanshankeji.compose.ui.color.Color
import com.huanshankeji.compose.ui.color.Colors
import com.huanshankeji.compose.ui.color.rgbColor
import com.huanshankeji.compose.ui.color.rgbaColor
import com.huanshankeji.compose.ui.height
import com.huanshankeji.compose.ui.unit.dpOrPx
import com.huanshankeji.compose.ui.width

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
                val size = 400.dpOrPx
                height(size)
                width(size)
            }
        }) {
            Column({
                style {
                    margin(16.dpOrPx)
                }
            }) {
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
                    ScrollableList({
                        style {
                            height(100.dpOrPx)
                        }
                    }) {
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

                Row({
                    style {
                        // The order of function calls can't be changed!
                        roundedCornerOuterBorder(4.dpOrPx, Colors.blue, 16.dpOrPx)
                        backgroundColor(rgbColor(0U, 0x80U, 0x00U))
                    }
                }) {
                    @Composable
                    fun DemoSquare(color: Color) =
                        Box({
                            style {
                                // The order of function calls can't be changed!
                                margin(8.dpOrPx)
                                backgroundColor(color)
                                val size = 40.dpOrPx
                                height(size)
                                width(size)
                            }
                        }) {}

                    DemoSquare(Colors.red)
                    DemoSquare(rgbColor(0xFFU, 0U, 0U))
                    DemoSquare(rgbaColor(0xFFU, 0U, 0U, 0x80U))
                    DemoSquare(rgbaColor(0xFFU, 0U, 0U, 0.5F))
                }

                var text by remember { mutableStateOf("") }
                TextField(
                    text, { text = it },
                    label = "Demo text field",
                    leadingIcon = { Icon(MaterialIcons.Add, null) },
                    trailingIcon = { Icon(MaterialIcons.Menu, null) })
            }
        }
    }
}
