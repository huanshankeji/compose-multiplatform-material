package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.material3.Icon
import com.huanshankeji.compose.ui.Modifier

/**
 * filled button
 * @param icon the [Modifier] parameter contains the attributes to be set on this icon on JS. You are supposed to pass this [Modifier] to the top-level composable that you invoke inside.
 */
@Composable
expect fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: @Composable ((Modifier) -> Unit)? = null,
    isTrailingIcon: Boolean = false,
    content: @Composable () -> Unit
)

@Composable
fun ButtonWithMaterialIcon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Icon?,
    isTrailingIcon: Boolean = false,
    content: @Composable () -> Unit
) =
    Button(
        onClick,
        modifier,
        enabled,
        icon?.let { { modifier -> Icon(it, null, modifier) } },
        isTrailingIcon,
        content
    )

/**
 * a shortcut to `Button`
 */
@Composable
fun FilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: @Composable ((Modifier) -> Unit)? = null,
    isTrailingIcon: Boolean = false,
    content: @Composable () -> Unit
) =
    Button(onClick, modifier, enabled, icon, isTrailingIcon, content)

@Composable
expect fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable ButtonScope.() -> Unit
)

@Composable
expect fun FilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable ButtonScope.() -> Unit
)

@Composable
expect fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable ButtonScope.() -> Unit
)

@Composable
expect fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable ButtonScope.() -> Unit
)

// TODO remove
expect class ButtonScope {
    @Composable
    fun Icon(/* TODO */)
}
