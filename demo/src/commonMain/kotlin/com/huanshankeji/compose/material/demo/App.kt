package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.BasicText
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.layout.padding
import com.huanshankeji.compose.layout.size
import com.huanshankeji.compose.material.*
import com.huanshankeji.compose.material.icon.MaterialIcons
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.color.Colors
import com.huanshankeji.compose.ui.color.rgbColor
import com.huanshankeji.compose.ui.graphics.Color
import com.huanshankeji.compose.ui.height
import com.huanshankeji.compose.ui.unit.dpOrPx
import com.huanshankeji.compose.ui.width
import com.huanshankeji.compose.layout.Row as LegacyRow

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
        /*
        // TODO use this
        run {
            val size = 400.dp
            Modifier.padding(16.dp).size(size)
        }
        */
        Card({
            style {
                margin(16.dpOrPx)
                val size = 400.dpOrPx
                height(size)
                width(size)
            }
        }) {
            Column(Modifier.padding(16.dp)) {
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

                Box(Modifier.padding(16.dp)) {
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

                // TODO
                LegacyRow({
                    style {
                        // The order of function calls can't be changed!
                        roundedCornerOuterBorder(4.dpOrPx, Colors.blue, 16.dpOrPx)
                        backgroundColor(rgbColor(0U, 0x80U, 0x00U))
                    }
                }) {
                    @Composable
                    fun DemoSquare(color: Color) =
                        Box(run {
                            val size = 40.dp
                            Modifier.padding(8.dp).background(color).size(size)
                        }) {} // TODO use `Box` that doesn't need the trailing lambda

                    DemoSquare(Color.Red)
                    DemoSquare(Color(0xFF, 0, 0))
                    DemoSquare(Color(0xFF, 0, 0, 0x80))
                    DemoSquare(Color(1f, 0f, 0f, 0.5f))
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
