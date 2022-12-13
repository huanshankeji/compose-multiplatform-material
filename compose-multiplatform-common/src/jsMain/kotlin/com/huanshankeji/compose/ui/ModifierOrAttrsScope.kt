package com.huanshankeji.compose.ui

import com.huanshankeji.compose.ui.unit.SizeValue
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.HTMLElement

fun <TElement : Element> ModifierOrAttrs<TElement>.toAttrs(): AttrBuilderContext<TElement>? =
    this?.let { { ModifierOrAttrsScope(this).it() } }

fun <TElement : Element> AttrBuilderContext<TElement>?.toModifierOrAttrs(): ModifierOrAttrs<TElement> =
    this?.let { { attrsScope.it() } }

actual typealias Element = HTMLElement

actual class ModifierOrAttrsScope<out TElement : Element>(val attrsScope: AttrsScope<TElement>) {
    actual fun style(builder: StyleScope.() -> Unit) =
        attrsScope.style { StyleScope(this).builder() }
}

actual class StyleScope(val styleScope: org.jetbrains.compose.web.css.StyleScope) {
    actual fun margin(value: SizeValue) =
        styleScope.margin(value.platformValue)
}
