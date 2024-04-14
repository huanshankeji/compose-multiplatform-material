package com.huanshankeji.compose.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.html.material3.MdButtonScope
import com.huanshankeji.compose.html.material3.MdElevatedButton
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
internal fun CommonButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable MdButtonScope.() -> Unit
) =
    MdElevatedButton(disabled = if (enabled) null else true,
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        content()
    }

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    content: @Composable RowScope.() -> Unit
) =
    CommonButton(onClick, modifier, enabled) {
        Row(content = content)
    }
