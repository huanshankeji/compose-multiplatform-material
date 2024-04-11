package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.foundation.border
import com.huanshankeji.compose.foundation.ext.outerBorder
import com.huanshankeji.compose.foundation.ext.roundedCornerBackgroundAndOuterBorder
import com.huanshankeji.compose.foundation.ext.roundedCornerOuterBorder
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.foundation.text.BasicText
import com.huanshankeji.compose.layout.padding
import com.huanshankeji.compose.layout.size
import com.huanshankeji.compose.material.*
import com.huanshankeji.compose.material.icon.MaterialIcons
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.graphics.Color
import com.huanshankeji.compose.ui.height
import com.huanshankeji.compose.ui.unit.dpOrPx
import com.huanshankeji.compose.ui.width
import com.huanshankeji.compose.material.ext.Button as ExtButton

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
        Modifier.padding(16.dp).height(800.dp).width(400.dp)
        */
        Card({
            style {
                margin(16.dpOrPx)
                height(800.dpOrPx)
                width(400.dpOrPx)
            }
        }) {
            Column(Modifier.padding(16.dp)) {
                BasicText("basic text 1")
                BasicText("basic text 2")
                Text("Material text")

                var count by remember { mutableStateOf(0) }
                val onClick: () -> Unit = { count++ }

                Row {
                    val buttonContent: @Composable RowScope.() -> Unit = {
                        Text(count.toString())
                    }
                    Button(onClick, content = buttonContent)
                    OutlinedButton(onClick, content = buttonContent)
                    TextButton(onClick, content = buttonContent)
                    ExtButton(onClick) {
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

                @Composable
                fun ColorBox(color: Color) =
                    Box(Modifier.padding(8.dp).background(color).size(40.dp))

                val halfGreen = Color(0, 0x80, 0x00)

                Row(Modifier.roundedCornerBackgroundAndOuterBorder(4.dp, Color.Blue, 16.dp, halfGreen)) {
                    ColorBox(Color.Red)
                    ColorBox(Color(0xFF, 0, 0))
                    ColorBox(Color(0xFF, 0, 0, 0x80))
                    ColorBox(Color(1f, 0f, 0f, 0.5f))
                }

                Row {
                    @Composable
                    fun NestedColorBox(modifier: Modifier) =
                        Box(modifier.background(halfGreen)) { ColorBox(Color.Red) }

                    NestedColorBox(Modifier.border(4.dp, Color.Blue))
                    NestedColorBox(Modifier.outerBorder(4.dp, Color.Blue))
                    NestedColorBox(Modifier.roundedCornerOuterBorder(4.dp, Color.Blue, 16.dp))
                    NestedColorBox(Modifier.roundedCornerOuterBorder(1.dp, Color.Blue, 16.dp))
                    val transparentBlue = Color(0, 0, 0x80, 0x80)
                    Box(Modifier.roundedCornerBackgroundAndOuterBorder(2.dp, transparentBlue, 16.dp, halfGreen)) {
                        ColorBox(Color.Red)
                    }
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
