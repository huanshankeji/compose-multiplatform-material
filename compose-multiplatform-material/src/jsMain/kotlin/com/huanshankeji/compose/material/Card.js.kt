package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.kobweb.compose.ui.modifiers.sizeFitContent
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.card.MDCCard
import com.varabyte.kobweb.compose.ui.Modifier as PlatformModifier

@Composable
actual fun Card(modifier: Modifier, content: @Composable () -> Unit) =
    MDCCard(attrs = PlatformModifier.sizeFitContent().then(modifier.platformModifier).toAttrs()) { content() }
