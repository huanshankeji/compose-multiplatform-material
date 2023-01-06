package com.huanshankeji.compose.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.NumericSize
import com.huanshankeji.compose.ui.unit.Size
import com.huanshankeji.compose.ui.unit.Size.*

fun <TElement : Element> ModifierOrAttrs<TElement>.toModifier(): Modifier =
    this?.let {
        ModifierOrAttrsScope<TElement>(Modifier).apply(it).modifier
    } ?: Modifier

fun <TElement : Element> Modifier.toModifierOrAttrs(): ModifierOrAttrs<TElement> =
    if (this !== Modifier) {
        { modify { this then this@toModifierOrAttrs } }
    } else null

actual abstract class Element

actual class ModifierOrAttrsScope<out TElement : Element>(modifier: Modifier) {
    var modifier: Modifier = modifier
        private set

    fun modify(block: Modifier.() -> Modifier) {
        modifier = modifier.block()
    }

    actual fun style(builder: StyleScope.() -> Unit) {
        StyleScope(this).builder()
    }
}

actual class StyleScope(val modifierOrAttrsScope: ModifierOrAttrsScope<*>) {
    actual fun margin(value: NumericSize) = modifierOrAttrsScope.modify {
        padding(value.platformValue)
    }

    actual fun height(value: Size) = modifierOrAttrsScope.modify {
        when (value) {
            FitContent -> this
            FillMax -> fillMaxHeight()
            is Numeric -> height(value.value.platformValue)
        }
    }

    actual fun width(value: Size) = modifierOrAttrsScope.modify {
        when (value) {
            FitContent -> this
            FillMax -> fillMaxHeight()
            is Numeric -> width(value.value.platformValue)
        }
    }
}
