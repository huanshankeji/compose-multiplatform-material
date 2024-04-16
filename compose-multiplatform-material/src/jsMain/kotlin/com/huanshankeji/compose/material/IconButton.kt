package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.icon.button.MDCIconButton


@Composable
actual fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable () -> Unit
) =
    MDCIconButton(attrs = modifier.platformModifier.toAttrs {
        onClick { onClick() }
    }) { content() }
