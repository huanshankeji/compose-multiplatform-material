package com.huanshankeji.compose.material3.lazy.ext

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.toNullableContentWithoutModifier
import com.huanshankeji.compose.ui.Modifier

actual class ListScope(val lazyListScope: LazyListScope) {
    @Composable
    private fun ListItem(content: ListItemComponents) =
        with(content) {
            ListItem(
                headline.toNullableContentWithoutModifier() ?: {},
                contentModifier.platformModifier,
                overline.toNullableContentWithoutModifier(),
                supportingText.toNullableContentWithoutModifier(),
                start.toNullableContentWithoutModifier(),
                trailingSupportingText?.let { trailingSupportingText ->
                    end?.let { end ->
                        {
                            Row {
                                trailingSupportingText(Modifier)
                                end(Modifier)
                            }
                        }
                    } ?: { trailingSupportingText(Modifier) }
                } ?: end?.let { end ->
                    { end(Modifier) }
                }
            )
        }


    actual fun item(
        key: Any?,
        contentType: Any?,
        content: @Composable () -> Unit
    ) =
        lazyListScope.item(key, contentType) { content() }

    actual fun conventionalItem(
        key: Any?,
        contentType: Any?,
        content: ListItemComponents
    ) =
        item(key, contentType) { ListItem(content) }

    actual fun items(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable (index: Int) -> Unit
    ) =
        lazyListScope.items(count, key, contentType) { index -> itemContent(index) }

    actual fun conventionalItems(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: (index: Int) -> ListItemComponents
    ) =
        items(count, key, contentType) { index ->
            ListItem(itemContent(index))
        }
}

@Composable
actual fun List(
    modifier: Modifier,
    content: ListScope.() -> Unit
) =
    LazyColumn(modifier.platformModifier) {
        ListScope(this).content()
    }
