package com.huanshankeji.compose.material

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toModifier

actual abstract class ListElement : Element()

actual class ListScope(val lazyListScope: LazyListScope) {
    actual fun itemInternal(key: Any?, contentType: Any?, content: @Composable ItemScope.() -> Unit) =
        lazyListScope.item(key, contentType) { ItemScope(this).content() }

    actual fun itemsInternal(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable ItemScope.(index: Int) -> Unit
    ) =
        lazyListScope.items(count, key, contentType) { ItemScope(this).itemContent(it) }

    @OptIn(ExperimentalFoundationApi::class)
    actual fun groupInternal(
        key: Any?,
        contentType: Any?,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: ListScope.() -> Unit
    ) {
        lazyListScope.stickyHeader(key, contentType) { HeaderScope(this).headerContent() }
        content()
    }
}

actual class ItemScope(val lazyItemScope: LazyItemScope)
actual typealias HeaderScope = ItemScope

@Composable
actual fun List(modifierOrAttrs: ModifierOrAttrs<ListElement>, content: ListScope.() -> Unit) =
    androidx.compose.foundation.lazy.LazyColumn(modifierOrAttrs.toModifier()) {
        ListScope(this).content()
    }
