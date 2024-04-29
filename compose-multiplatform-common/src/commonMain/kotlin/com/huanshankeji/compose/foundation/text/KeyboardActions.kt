package com.huanshankeji.compose.foundation.text

import com.huanshankeji.compose.foundation.text.input.ImeAction
import kotlin.jvm.JvmInline

// copied and adapted from `androidx.compose.foundation.text`

@JvmInline
value class KeyboardActions(
    val onAny: KeyboardActionScope.() -> Unit,
)

interface KeyboardActionScope {
    fun defaultKeyboardAction(imeAction: ImeAction)
}
