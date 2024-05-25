package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.*
import com.huanshankeji.compose.foundation.ext.outerBorder
import com.huanshankeji.compose.foundation.ext.roundedCornerBackgroundAndOuterBorder
import com.huanshankeji.compose.foundation.ext.roundedCornerOuterBorder
import com.huanshankeji.compose.foundation.layout.Arrangement
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.lazy.LazyColumn
import com.huanshankeji.compose.foundation.lazy.LazyListScope
import com.huanshankeji.compose.foundation.lazy.LazyRow
import com.huanshankeji.compose.foundation.text.BasicText
import com.huanshankeji.compose.layout.height
import com.huanshankeji.compose.layout.padding
import com.huanshankeji.compose.layout.size
import com.huanshankeji.compose.layout.width
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.graphics.Color

@Composable
fun Common(modifier: Modifier) {
    Column(modifier, Arrangement.spacedBy(16.dp)) {
        BasicText("basic text 1")
        BasicText("basic text 2")

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

        var count by remember { mutableStateOf(0) }
        BasicText("Click to add items", Modifier.onClick { count++ })
        val lazyListContent: LazyListScope.() -> Unit = {
            item { BasicText("Item") }
            items(count) { index -> BasicText("Item $index") }
        }
        BasicText("`LazyColumn`")
        LazyColumn(Modifier.height(listSize), content = lazyListContent)
        BasicText("`LazyRow`")
        LazyRow(Modifier.width(listSize), content = lazyListContent)

        @Composable
        fun ColumnOrRowContent() {
            BasicText("Item")
            repeat(count) { index -> BasicText("Item $index") }
        }
        BasicText("`Column` with scroll")
        Column(Modifier.height(listSize).verticalScroll(rememberScrollState())) {
            ColumnOrRowContent()
        }
        BasicText("`Row` with scroll")
        Row(Modifier.width(listSize).horizontalScroll(rememberScrollState())) {
            ColumnOrRowContent()
        }
    }
}