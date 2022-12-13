package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class TextElement : Element

@RequiresOptIn(
    "The `com.huanshankeji.compose.material.Text` function " +
            "can be easily confused with other Composable functions named `Text` " +
            "such as `androidx.compose.material.Text` and `org.jetbrains.compose.web.dom.Text` " +
            "if not careful. " +
            "Opt-in to use this API or use `MaterialText` instead.",
    RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ConfusableTextApi

@ConfusableTextApi
@Composable
expect fun Text(text: String, modifierOrAttrs: ModifierOrAttrs<TextElement> = null)

@Suppress("NOTHING_TO_INLINE")
@OptIn(ConfusableTextApi::class)
@Composable
inline fun MaterialText(text: String, noinline modifierOrAttrs: ModifierOrAttrs<TextElement> = null) =
    Text(text, modifierOrAttrs)
