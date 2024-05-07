package com.huanshankeji.compose.material3.lazy.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.material3.ext.toNullableContentWithModifier
import com.huanshankeji.compose.material3.ext.toNullableTextWithModifier
import com.huanshankeji.compose.ui.Modifier

expect class ListScope {
    fun item(key: Any? = null, contentType: Any? = null, content: @Composable () -> Unit)

    // the word "conventional" added to be consistent with `conventionalItems`
    fun conventionalItem(key: Any? = null, contentType: Any? = null, content: ListItemComponents)

    fun items(
        count: Int,
        key: ((index: Int) -> Any)? = null,
        contentType: (index: Int) -> Any? = { null },
        itemContent: @Composable (index: Int) -> Unit
    )

    // the word "conventional" added to avoid clashing with `items`
    fun conventionalItems(
        count: Int,
        key: ((index: Int) -> Any)? = null,
        contentType: (index: Int) -> Any? = { null },
        itemContent: (index: Int) -> ListItemComponents
    )
}

class ListItemComponents(
    val contentModifier: Modifier = Modifier,
    val headline: @Composable ((Modifier) -> Unit)? = null,
    val start: @Composable ((Modifier) -> Unit)? = null,
    val end: @Composable ((Modifier) -> Unit)? = null,
    val supportingText: @Composable ((Modifier) -> Unit)? = null,
    val trailingSupportingText: @Composable ((Modifier) -> Unit)? = null,
    val overline: @Composable ((Modifier) -> Unit)? = null
) {
    constructor(
        contentModifier: Modifier = Modifier,
        headline: String? = null,
        start: Icon? = null,
        end: Icon? = null,
        supportingText: String? = null,
        trailingSupportingText: String? = null,
        overline: String? = null
    ) : this(
        contentModifier,
        headline.toNullableTextWithModifier(),
        start.toNullableContentWithModifier(),
        end.toNullableContentWithModifier(),
        supportingText.toNullableTextWithModifier(),
        trailingSupportingText.toNullableTextWithModifier(),
        overline.toNullableTextWithModifier()
    )
}

@Composable
expect fun List(modifier: Modifier = Modifier, content: ListScope.() -> Unit)

/**
 * An alias for [List] that is more similar to `androidx.compose.foundation.layout.LazyColumn`.
 */
@Composable
fun LazyColumnList(modifier: Modifier = Modifier, content: ListScope.() -> Unit) =
    List(modifier, content)
