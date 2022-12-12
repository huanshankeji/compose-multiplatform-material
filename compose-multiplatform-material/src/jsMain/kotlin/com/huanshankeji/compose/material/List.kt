package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.ModifierOrAttrs
import com.huanshankeji.compose.ui.toAttrs
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListGroup
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.list.Subheader
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.list.item.MDCListItemScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

actual typealias ListElement = HTMLUListElement

/**
 * This class contains mutable fields.
 * @see androidx.compose.foundation.lazy.LazyListScopeImpl
 */
actual class ListScope(
    val mdcListScope: MDCListScope<HTMLUListElement>
) {
    private var composables: MutableList<@Composable () -> Unit>? = null
    private fun addComposable(composable: @Composable () -> Unit) {
        composables!!.add(composable)
    }

    /** Add the composable functions with the non-composable functions and then invoke them. */
    @Composable
    fun ComposableRun(content: ListScope.() -> Unit) {
        composables = mutableListOf()
        content()
        for (composable in composables!!)
            composable()
        composables = null
    }


    actual fun itemInternal(key: Any?, contentType: Any?, content: @Composable ItemScope.() -> Unit) = addComposable {
        mdcListScope.ListItem { ItemScope(this).content() }
    }

    actual fun itemsInternal(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable ItemScope.(index: Int) -> Unit
    ) = addComposable {
        repeat(count) { i ->
            mdcListScope.ListItem { ItemScope(this).itemContent(i) }
        }
    }

    actual fun groupInternal(
        key: Any?,
        contentType: Any?,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: ListScope.() -> Unit
    ) = addComposable {
        MDCListGroup {
            Subheader {
                HeaderScope(this).headerContent()
            }
            MDCList {
                ListScope(this).ComposableRun(content)
            }
        }
    }
}

actual class ItemScope(val mdcListItemScope: MDCListItemScope<HTMLLIElement>)
actual class HeaderScope(val elementScope: ElementScope<HTMLHeadingElement>)

@Composable
actual fun List(modifierOrAttrs: ModifierOrAttrs<ListElement>, content: ListScope.() -> Unit) =
    MDCList(attrs = modifierOrAttrs.toAttrs()) {
        ListScope(this).ComposableRun(content)
    }
