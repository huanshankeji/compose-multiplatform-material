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

actual class ListScope(
    val mdcListScope: MDCListScope<HTMLUListElement>
) {
    @Composable
    actual fun item(key: Any?, contentType: Any?, content: @Composable ItemScope.() -> Unit) {
        mdcListScope.ListItem { ItemScope(this).content() }
    }

    @Composable
    actual fun items(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable ItemScope.(index: Int) -> Unit
    ) {
        repeat(count) { i ->
            mdcListScope.ListItem { ItemScope(this).itemContent(i) }
        }
    }

    @Composable
    actual fun group(
        key: Any?,
        contentType: Any?,
        headerContent: @Composable HeaderScope.() -> Unit,
        content: ListScope.() -> Unit
    ) {
        MDCListGroup {
            Subheader {
                HeaderScope(this).headerContent()
            }
            MDCList {
                ListScope(this).content()
            }
        }
    }
}

actual class ItemScope(val mdcListScope: MDCListItemScope<HTMLLIElement>)
actual class HeaderScope(val htmlHeadingElementScope: ElementScope<HTMLHeadingElement>)

@Composable
actual fun List(modifierOrAttrs: ModifierOrAttrs<ListElement>, content: @Composable ListScope.() -> Unit) =
    MDCList(attrs = modifierOrAttrs.toAttrs()) {
        ListScope(this).content()
    }
