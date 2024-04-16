package com.huanshankeji.compose.material

//import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Element
import com.huanshankeji.compose.ui.ModifierOrAttrs

expect abstract class ListElement : Element


/** @see LazyListScope */
expect class ListScope {
    /*
    There is a compiler bug of calling the functions below with default arguments.
    The issue link (already resolved): https://github.com/JetBrains/compose-multiplatform/issues/2806
     */

    internal fun itemInternal(key: Any? = null, contentType: Any? = null, content: @Composable ItemScope.() -> Unit)

    internal fun itemsInternal(
        count: Int,
        key: ((index: Int) -> Any)? = null,
        contentType: (index: Int) -> Any? = { null },
        itemContent: @Composable ItemScope.(index: Int) -> Unit
    )

    internal fun groupInternal(
        key: Any? = null,
        contentType: Any? = null,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: ListScope.() -> Unit
    )
}


fun ListScope.item(key: Any? = null, contentType: Any? = null, content: @Composable ItemScope.() -> Unit) =
    itemInternal(key, contentType, content)

fun ListScope.items(
    count: Int,
    key: ((index: Int) -> Any)? = null,
    contentType: (index: Int) -> Any? = { null },
    itemContent: @Composable ItemScope.(index: Int) -> Unit
) =
    itemsInternal(count, key, contentType, itemContent)

fun ListScope.group(
    key: Any? = null,
    contentType: Any? = null,
    headerContent: @Composable HeaderScope.() -> Unit,
    content: ListScope.() -> Unit
) =
    groupInternal(key, contentType, headerContent, content)


expect class ItemScope
expect class HeaderScope


@Composable
expect fun ScrollableList(modifierOrAttrs: ModifierOrAttrs<ListElement> = null, content: ListScope.() -> Unit)

/**
 * An alias for [ScrollableList] that follows the name of [androidx.compose.foundation.lazy.LazyColumn].
 * The current implementation is not actually lazy on web.
 */
@Composable
fun LazyColumn(modifierOrAttrs: ModifierOrAttrs<ListElement> = null, content: ListScope.() -> Unit) =
    ScrollableList(modifierOrAttrs, content)
