package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.web.css.FIT_CONTENT
import com.huanshankeji.compose.web.css.width
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.card.MDCCard

@Composable
actual fun Card(modifier: Modifier, content: @Composable () -> Unit) =
    MDCCard(attrs = modifier.platformModifier.toAttrs {
        style {
            width(FIT_CONTENT)
        }
    }) { content() }
