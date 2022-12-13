package com.huanshankeji.compose.ui

//import androidx.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.SizeValue

typealias ModifierOrAttrs<TElement> = (ModifierOrAttrsScope<TElement>.() -> Unit)?

expect abstract class Element

expect class ModifierOrAttrsScope<out TElement : Element> {
    fun style(builder: StyleScope.() -> Unit)
}

expect class StyleScope {
    fun margin(value: SizeValue)
}

private const val PADDING_MESSAGE =
    "This function is a placeholder for code completion. " +
            "Use `margin` to add space around the composable, which is equivalent to `Modifier.padding`. " +
            "Set `margin` in the inner composable to add inner padding."

@Deprecated(PADDING_MESSAGE)
fun StyleScope.padding(value: SizeValue): Unit =
    throw NotImplementedError(PADDING_MESSAGE)

/*
/** An alternative immutable design like [Modifier]. */
expect class ModifierOrAttrsImmutable<T : Element> {
    fun padding(): ModifierOrAttrsImmutable<T>
}
*/
