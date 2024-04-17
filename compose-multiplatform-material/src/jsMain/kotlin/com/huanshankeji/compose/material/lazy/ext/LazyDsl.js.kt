package com.huanshankeji.compose.material.lazy.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListGroup
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.list.Subheader
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.list.item.MDCListItemScope
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

/**
 * This class contains mutable fields.
 * @see androidx.compose.foundation.lazy.LazyListScopeImpl
 */
actual class LazyListScope(
    val mdcListScope: MDCListScope<HTMLUListElement>
) {
    private var composables: MutableList<@Composable () -> Unit>? = null
    private fun addComposable(composable: @Composable () -> Unit) {
        composables!!.add(composable)
    }

    /** Add the composable functions with the non-composable functions and then invoke them. */
    @Composable
    fun ComposableRun(content: LazyListScope.() -> Unit) {
        composables = mutableListOf()
        content()
        for (composable in composables!!)
            composable()
        composables = null
    }


    actual fun item(key: Any?, contentType: Any?, content: @Composable LazyItemScope.() -> Unit) = addComposable {
        mdcListScope.ListItem { LazyItemScope(this).content() }
    }

    actual fun items(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable LazyItemScope.(index: Int) -> Unit
    ) = addComposable {
        repeat(count) { i ->
            mdcListScope.ListItem { LazyItemScope(this).itemContent(i) }
        }
    }

    actual fun group(
        key: Any?,
        contentType: Any?,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: LazyListScope.() -> Unit
    ) = addComposable {
        MDCListGroup {
            Subheader {
                HeaderScope(this).headerContent()
            }
            MDCList {
                LazyListScope(this).ComposableRun(content)
            }
        }
    }
}

actual class LazyItemScope(val mdcListItemScope: MDCListItemScope<HTMLLIElement>)
actual class HeaderScope(val headingElementScope: ElementScope<HTMLHeadingElement>)

@Composable
actual fun LazyColumn(modifier: Modifier, content: LazyListScope.() -> Unit) =
    MDCList(attrs = modifier.platformModifier.toAttrs {
        style {
            //overflowY("scroll")
            overflowY("auto")
        }
    }) {
        LazyListScope(this).ComposableRun(content)
    }
