package com.huanshankeji.compose.material.lazy.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

/** @see androidx.compose.foundation.lazy.LazyListScope */
expect class ListScope {
    fun item(key: Any? = null, contentType: Any? = null, content: @Composable LazyItemScope.() -> Unit)

    fun items(
        count: Int,
        key: ((index: Int) -> Any)? = null,
        contentType: (index: Int) -> Any? = { null },
        itemContent: @Composable LazyItemScope.(index: Int) -> Unit
    )

    fun group(
        key: Any? = null,
        contentType: Any? = null,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: ListScope.() -> Unit
    )
}

expect class LazyItemScope /*{
    fun Modifier.fillParentMaxSize(@FloatRange(from = 0.0, to = 1.0) fraction: Float = 1f): Modifier
    fun Modifier.fillParentMaxWidth(@FloatRange(from = 0.0, to = 1.0) fraction: Float = 1f): Modifier
    fun Modifier.fillParentMaxHeight(@FloatRange(from = 0.0, to = 1.0) fraction: Float = 1f): Modifier
}*/

expect class HeaderScope

/**
 * The current implementation is not actually lazy on web, but it seems not necessary to be.
 */
@Composable
expect fun List(modifier: Modifier = Modifier, content: ListScope.() -> Unit)

/**
 * An alias for [List] that is more similar to `androidx.compose.foundation.layout.LazyColumn`.
 */
@Composable
fun LazyColumnList(modifier: Modifier = Modifier, content: ListScope.() -> Unit) =
    List(modifier, content)
