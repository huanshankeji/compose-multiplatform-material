package com.huanshankeji.compose.ui

//import androidx.compose.ui.Modifier
import com.huanshankeji.compose.ui.unit.NumericSize
import com.huanshankeji.compose.ui.unit.Size

typealias NotNullModifierOrAttrs<TElement> = ModifierOrAttrsScope<TElement>.() -> Unit
typealias ModifierOrAttrs<TElement> = NotNullModifierOrAttrs<TElement>?

@Suppress("NOTHING_TO_INLINE")
inline fun <TElement : Element> modifierOrAttrs(noinline modifierOrAttrs: NotNullModifierOrAttrs<TElement>) =
    modifierOrAttrs

operator fun <TElement : Element> NotNullModifierOrAttrs<TElement>.plus(other: ModifierOrAttrs<TElement>): ModifierOrAttrs<TElement> =
    if (other === null) this
    else {
        {
            this@plus()
            other()
        }
    }


expect abstract class Element


expect class ModifierOrAttrsScope<out TElement : Element> {
    fun style(builder: StyleScope.() -> Unit)
}

expect class StyleScope {
    fun margin(value: NumericSize)
    fun height(value: Size)
    fun width(value: Size)
}

fun StyleScope.height(value: NumericSize) =
    height(Size.Numeric(value))

fun StyleScope.width(value: NumericSize) =
    width(Size.Numeric(value))

private const val PADDING_MESSAGE =
    "This function is a placeholder for code completion. " +
            "Use `margin` to add space around the composable, which is equivalent to `Modifier.padding`. " +
            "Set `margin` in the inner composable to add inner padding."

@Deprecated(PADDING_MESSAGE)
fun StyleScope.padding(value: NumericSize): Unit =
    throw NotImplementedError(PADDING_MESSAGE)

/*
/** An alternative immutable design like [Modifier]. */
expect class ModifierOrAttrsImmutable<T : Element> {
    fun padding(): ModifierOrAttrsImmutable<T>
}
*/
