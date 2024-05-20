package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.huanshankeji.compose.material.icons.Icon
import com.huanshankeji.compose.ui.Modifier

/**
 * @param onDismissRequestAndroidxCommonOnly not supported on JS.
 * @param onCloseJsOnly JS only
 */
@Composable
expect fun DropdownMenu(
    expanded: Boolean,
    onDismissRequestAndroidxCommonOnly: () -> Unit,
    onCloseJsOnly: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = defaultDpOffset,
    //scrollState: ScrollState = rememberScrollState(),
    content: @Composable () -> Unit
)

internal val defaultDpOffset = DpOffset(0.dp, 0.dp)

/**
 * @param keepOpenJsOnly set to `true` for completely consistent behavior on JS to `androidx.compose`. However, if you set the `expanded` state to false in [onClick], doing this is unnecessary.
 */
@Composable
expect fun DropdownMenuItem(
    text: @Composable (Modifier) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable ((Modifier) -> Unit)? = null,
    trailingIcon: @Composable ((Modifier) -> Unit)? = null,
    enabled: Boolean = true,
    keepOpenJsOnly: Boolean = false
)

@Composable
fun DropdownMenuItemWithMaterialIcons(
    text: @Composable (Modifier) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: Icon? = null,
    trailingIcon: Icon? = null,
    enabled: Boolean = true
) =
    DropdownMenuItem(
        text,
        onClick,
        modifier,
        leadingIcon.toNullableContentWithModifier(),
        trailingIcon.toNullableContentWithModifier(),
        enabled
    )
