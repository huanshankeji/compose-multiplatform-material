package com.huanshankeji.compose.foundation.layout.ext

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.foundation.ExperimentalFoundationApi
import com.huanshankeji.compose.foundation.layout.Box
import com.huanshankeji.compose.ui.Alignment
import com.huanshankeji.compose.ui.Modifier
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
    Box(
        Modifier.platformModify {
            attrsModifier {
                ref {
                    clientSize = ClientSize(it.clientWidth, it.clientHeight)
                    onDispose { clientSize = null }
                }
            }
        }.then(modifier),
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
