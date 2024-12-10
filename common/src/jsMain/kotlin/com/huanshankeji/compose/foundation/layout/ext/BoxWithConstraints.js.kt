package com.huanshankeji.compose.foundation.layout.ext

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.ExperimentalFoundationApi
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.browser.dom.observers.ResizeObserver
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.ui.attrsModifier

@ExperimentalFoundationApi
@Composable
actual fun BoxWithConstraints(
    modifier: Modifier,
    contentAlignment: Alignment,
    content: @Composable BoxWithConstraintsScope.() -> Unit
) {
    var clientSize by remember { mutableStateOf<ClientSize?>(null) }
    // `DivBox` doesn't work here either, so it should not be Kobweb's problem.
    Box(
        Modifier.fillMaxSizeStretch()
            .platformModify {
                attrsModifier {
                    ref {
                        //clientSize = ClientSize(it.clientWidth, it.clientHeight) // Adding this doesn't make a difference to solve the issue below.
                        val resizeObserver = ResizeObserver { entries, _ ->
                            val element = entries.first().target

                            /*
                            console.log("width: ${element.clientWidth}, height: ${element.clientHeight}")
                            console.log(entries.first().contentBoxSize.first())
                            console.log(entries.first().borderBoxSize.first())
                            console.log(entries.first().devicePixelContentBoxSize.first())
                            */

                            /* FIXME The height is sometimes 0 when resizing,
                                a non-zero size (as filtered through below) is not observed in time,
                                and sometimes a child element doesn't show,
                                until it's inspected with the Chrome Dev Tools.
                            I don't know whether this is a browser bug or a bug in our implementation.
                            Therefore, the 0 size changes are filtered out.
                            Uncomment the commented `console.log` debug code above to debug this further. */
                            with(element) {
                                if (clientWidth != 0 && clientHeight != 0) {
                                    //console.log("width: ${element.clientWidth}, height: ${element.clientHeight}")
                                    clientSize = ClientSize(clientWidth, clientHeight)
                                }
                            }
                        }
                        resizeObserver.observe(it)

                        onDispose {
                            //resizeObserver.unobserve(it)
                            resizeObserver.disconnect()
                            clientSize = null
                        }
                    }
                }
            }
            .then(modifier),
        contentAlignment
    ) {
        clientSize?.let {
            // TODO extra conversions might be needed in some cases when converting to `dp`
            BoxWithConstraintsScopeImpl(platformBoxScope, it.clientWidth.dp, it.clientHeight.dp).content()
        }
    }
}

@Stable
class BoxWithConstraintsScopeImpl(
    override val platformBoxScope: BoxScope,
    override val maxWidth: Dp,
    override val maxHeight: Dp
) : BoxWithConstraintsScope

private class ClientSize(val clientWidth: Int, val clientHeight: Int)
