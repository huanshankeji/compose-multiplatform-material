package com.huanshankeji.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.huanshankeji.compose.ui.Modifier

@Composable
expect fun rememberScrollState(initial: Int = 0): ScrollState

/**
 * Not working on JS yet and delegating to [Unit].
 */
@Stable
expect class ScrollState

/*
It seems `state` has to be achieved with `DisposableEffect` on JS which can not be set with the Kobweb `Modifier` yet.
See https://developer.mozilla.org/en-US/docs/Web/API/Element/scrollTop.
 */
/**
 * Note that if the component is a layout, it applies to the target as a whole on `androidx` targets, but applies to its content on JS DOM.
 */
expect fun Modifier.verticalScroll(
    state: ScrollState
    /*
    enabled: Boolean = true,
    flingBehavior: FlingBehavior? = null,
    reverseScrolling: Boolean = false
    */
): Modifier

expect fun Modifier.horizontalScroll(state: ScrollState): Modifier

/*
@Composable
expect fun VerticalScrollBox(content : @Composable () ->Unit)
*/
