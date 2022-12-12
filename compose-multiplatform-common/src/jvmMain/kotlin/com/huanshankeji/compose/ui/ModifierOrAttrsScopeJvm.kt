package com.huanshankeji.compose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.SizeValue

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
    actual fun padding(value: SizeValue) = modifierOrAttrsScope.modify {
        padding(value.platformValue)
    }
}
