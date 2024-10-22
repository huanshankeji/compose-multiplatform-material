package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.huanshankeji.compose.foundation.background
import com.huanshankeji.compose.foundation.layout.*
import com.huanshankeji.compose.foundation.layout.ext.innerPadding
import com.huanshankeji.compose.material3.Button
import com.huanshankeji.compose.material3.ext.TaglessText
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.graphics.Color

internal enum class Selection {
    A, B, C
}

val listSize = 160.dp

fun Modifier.contentPadding() = padding(16.dp)
val contentPaddingModifier = Modifier.contentPadding()

enum class Screen {
    Home, Common, Material2, Material3
}

@Composable
fun App() {
    Box(Modifier.background(Color.Green).size(800.dp).innerPadding(150.dp)) {
        Box(Modifier.background(Color.Yellow).innerPadding(150.dp)) {
            Box(Modifier.background(Color.Red).size(400.dp))
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Button({ navController.navigate(Screen.Common.name) }) {
                TaglessText("Common")
            }
            Button({ navController.navigate(Screen.Material2.name) }) {
                TaglessText("Material 2")
            }
            Button({ navController.navigate(Screen.Material3.name) }) {
                TaglessText("Material 3")
            }
        }
    }
}
