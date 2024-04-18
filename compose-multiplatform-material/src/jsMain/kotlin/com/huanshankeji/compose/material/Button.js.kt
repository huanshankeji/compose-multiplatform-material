package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.material.ext.ButtonType
import com.huanshankeji.compose.material.ext.toMDCButtonType
import com.huanshankeji.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import dev.petuska.kmdc.button.MDCButton

@Composable
private fun Button(
    onClick: () -> Unit,
    buttonType: ButtonType,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    MDCButton(buttonType.toMDCButtonType(),
        attrs = modifier.platformModifier.toAttrs {
            onClick { onClick() }
        }) {
        Row(content = content)
    }

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    Button(onClick, ButtonType.Contained, modifier, content)

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    Button(onClick, ButtonType.Outlined, modifier, content)

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) =
    Button(onClick, ButtonType.Text, modifier, content)
