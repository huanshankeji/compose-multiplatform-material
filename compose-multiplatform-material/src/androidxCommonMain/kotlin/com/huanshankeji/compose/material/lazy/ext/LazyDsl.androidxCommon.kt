package com.huanshankeji.compose.material.lazy.ext

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyItemScope as PlatformLazyItemScope
import androidx.compose.foundation.lazy.LazyListScope as PlatformLazyListScope

actual class ListScope(val platformValue: PlatformLazyListScope) {
    actual fun item(key: Any?, contentType: Any?, content: @Composable LazyItemScope.() -> Unit) =
        platformValue.item(key, contentType) { LazyItemScope(this).content() }

    actual fun items(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable LazyItemScope.(index: Int) -> Unit
    ) =
        platformValue.items(count, key, contentType) { LazyItemScope(this).itemContent(it) }

    @OptIn(ExperimentalFoundationApi::class)
    actual fun group(
        key: Any?,
        contentType: Any?,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: ListScope.() -> Unit
    ) {
        platformValue.stickyHeader(key, contentType) { HeaderScope(this).headerContent() }
        content()
    }
}

actual class LazyItemScope(val platformValue: PlatformLazyItemScope)
actual typealias HeaderScope = LazyItemScope

@Composable
actual fun List(modifier: Modifier, content: ListScope.() -> Unit) =
    // Note that it's actually in the `foundation` package.
    androidx.compose.foundation.lazy.LazyColumn(modifier.platformModifier) {
        ListScope(this).content()
    }
