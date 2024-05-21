package com.huanshankeji.compose.foundation

import androidx.compose.runtime.*
import com.huanshankeji.compose.foundation.ext.css.horizontalScroll
import com.huanshankeji.compose.foundation.ext.css.verticalScroll
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.PlatformModifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.w3c.dom.Element

fun PlatformModifier.verticalScroll(state: ScrollState) =
    styleModifier { verticalScroll() }
        .attrsModifier {
            onScroll {
                state._value = (it.target as Element).scrollTop.toInt()
            }
            /*
            TODO `DisposableEffect` is still needed to sync the `state` onto the `Element` whenever the `state.value` changes.
             `ref` can't work here because it doesn't take `keys`.
             */
        }

fun PlatformModifier.horizontalScroll(state: ScrollState) =
    styleModifier { horizontalScroll() }
        .attrsModifier {
            onScroll {
                state._value = (it.target as Element).scrollLeft.toInt()
            }
            // TODO `ditto`
        }

val verticalScrollPlatformModifier = PlatformModifier.verticalScroll(ScrollState(0))
val horizontalScrollPlatformModifier = PlatformModifier.horizontalScroll(ScrollState(0))


@Composable
actual fun rememberScrollState(initial: Int): ScrollState =
    ScrollState(initial)

@Stable
actual class ScrollState actual constructor(initial: Int) {
    var _value: Int by mutableIntStateOf(initial)
    actual val value: Int get() = _value

    actual suspend fun animateScrollTo(value: Int) {
        // TODO animation may not be supported on JS
        _value = value
    }

    actual suspend fun scrollTo(value: Int): Float {
        val oldValue = _value
        _value = value
        // see: https://developer.mozilla.org/en-US/docs/Web/API/Element/scrollTop
        return (_value - oldValue).toFloat()
    }
}

actual fun Modifier.verticalScroll(state: ScrollState): Modifier =
    platformModify { verticalScroll(state) }


actual fun Modifier.horizontalScroll(state: ScrollState): Modifier =
    platformModify { horizontalScroll(state) }
