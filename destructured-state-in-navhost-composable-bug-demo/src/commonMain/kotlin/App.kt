package com.huanshankeji.androidx.navigation.compose.bug

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.huanshankeji.androidx.navigation.compose.composable
import com.huanshankeji.androidx.navigation.compose.rememberNavController
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.onClick
import com.huanshankeji.compose.foundation.text.BasicText
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.androidx.navigation.compose.NavHost as OurNavHost

@Composable
fun App() {
    val (count, setCount) = remember { mutableStateOf(0) }
    val navController = rememberNavController()
    val clickToIncCountModifier = Modifier.onClick {
        setCount(count + 1)
    }

    Column {
        BasicText("Count outside: $count", clickToIncCountModifier)
        OurNavHost(navController, "0") {
            repeat(4) { i ->
                composable(i.toString()) {
                    Column {
                        BasicText("Screen $i")
                        BasicText("Count in `NavHost`: $count", clickToIncCountModifier)
                    }
                }
            }
        }
        /*
        AndroidxNavHost(navController, "0") {
            repeat(4) { i ->
                composable(i.toString()) {
                    Column {
                        BasicText("Screen $i")
                        BasicText("Count in `NavHost`: $count", clickToIncCountModifier)
                    }
                }
            }
        }
        */
    }
}
