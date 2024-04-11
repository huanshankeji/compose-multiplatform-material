package com.huanshankeji.compose.material.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.Modifier

@Composable
expect fun Button(
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.Contained,
    modifier: Modifier = Modifier,
    content: @Composable ButtonScope.() -> Unit
)

expect /*value*/ class ButtonScope {
    @Composable
    fun Label(text: String)
}

expect abstract class ButtonElement : Element

enum class ButtonType {
    Contained, Outlined, Text
}
