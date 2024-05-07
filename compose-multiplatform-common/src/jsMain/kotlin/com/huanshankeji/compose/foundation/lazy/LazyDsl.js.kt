package com.huanshankeji.compose.foundation.lazy

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.layout.Arrangement
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.runtime.DeferredComposableRunner
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.overflowX
import com.varabyte.kobweb.compose.css.overflowY
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.StyleScope

/*
@LazyScopeMarker
@JvmDefaultWithCompatibility
*/
actual class LazyListScope {
    private val deferredComposableRunner = DeferredComposableRunner()

    private fun addComposable(composable: @Composable () -> Unit) =
        deferredComposableRunner.addComposable(composable)

    @Composable
    internal fun ComposableRun(content: LazyListScope.() -> Unit) =
        deferredComposableRunner.ComposableRun { content() }

    actual fun item(
        key: Any?,
        contentType: Any?,
        content: @Composable LazyItemScope.() -> Unit
    ) =
        addComposable { LazyItemScope.content() }

    actual fun items(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable LazyItemScope.(index: Int) -> Unit
    ) =
        addComposable {
            repeat(count) { index ->
                LazyItemScope.itemContent(index)
            }
        }
}

@Composable
actual fun LazyRow(
    modifier: Modifier,
    reverseLayout: Boolean, // This parameter is not used yet but affects the arrangement in the default argument of the corresponding `expect` function.
    horizontalArrangement: Arrangement.Horizontal,
    verticalAlignment: Alignment.Vertical,
    content: LazyListScope.() -> Unit
) =
    Row(modifier.platformModify {
        styleModifier { rowOverflow() }
    }, horizontalArrangement, verticalAlignment) {
        LazyListScope().ComposableRun(content)
    }

@Composable
actual fun LazyColumn(
    modifier: Modifier,
    reverseLayout: Boolean, // This parameter is not used yet but affects the arrangement in the default argument of the corresponding `expect` function.
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    content: LazyListScope.() -> Unit
) =
    Column(modifier.platformModify {
        styleModifier { columnOverflow() }
    }, verticalArrangement, horizontalAlignment) {
        LazyListScope().ComposableRun(content)
    }


fun StyleScope.rowOverflow() =
    overflowX(Overflow.Auto)

fun StyleScope.columnOverflow() =
    //overflowY(Overflow.Scroll)
    overflowY(Overflow.Auto)
