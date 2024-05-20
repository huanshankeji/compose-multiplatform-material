package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpOffset
import androidx.compose.web.events.SyntheticEvent
import com.huanshankeji.compose.html.material3.*
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.toAttrs
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.isFalseOrNull
import com.huanshankeji.compose.web.attributes.isTrueOrNull
import com.varabyte.kobweb.compose.ui.attrsModifier
import org.jetbrains.compose.web.dom.ElementScope

@Composable
internal fun CommonDropdownMenu(
    //anchor: String?,
    expanded: Boolean,
    onCloseJsOnly: () -> Unit,
    //onDismissRequest: () -> Unit,
    attrs: Attrs<MdMenuElement>?,
    offset: DpOffset = defaultDpOffset,
    content: @Composable ElementScope<MdMenuElement>.() -> Unit
    //onExpandedChange: ((Boolean) -> Unit)? = null
) =
    MdMenu(
        open = expanded.isTrueOrNull(),
        xOffset = offset.x.value.takeIf { it != 0f },
        yOffset = offset.y.value.takeIf { it != 0f },
        attrs = {
            /*onExpandedChange?.let {
                onOpening<SyntheticEvent<*>> { it(true) }
                onClosing<SyntheticEvent<*>> {
                    onDismissRequest()
                    it(false)
                }
            }*/
            //onClosing<SyntheticEvent<*>> { onDismissRequest() } // the `androidx.compose` one invokes `onDismissRequest` only when the menu is closed and an item is not selected.
            onClosing<SyntheticEvent<*>> { onCloseJsOnly() }

            attrs?.invoke(this)
        }, content = content
    )

@Composable
actual fun DropdownMenu(
    expanded: Boolean,
    onDismissRequestAndroidxCommonOnly: () -> Unit,
    onCloseJsOnly: () -> Unit,
    modifier: Modifier,
    offset: DpOffset,
    content: @Composable () -> Unit
) =
    CommonDropdownMenu(expanded, onCloseJsOnly, modifier.toAttrs(), offset) { content() }

@Composable
actual fun DropdownMenuItem(
    text: @Composable (Modifier) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier,
    leadingIcon: @Composable ((Modifier) -> Unit)?,
    trailingIcon: @Composable ((Modifier) -> Unit)?,
    enabled: Boolean,
    keepOpenJsOnly: Boolean
) =
    MdMenuItem(
        enabled.isFalseOrNull(),
        keepOpen = keepOpenJsOnly.isTrueOrNull(),
        attrs = modifier.toAttrs {
            onClick {
                onClick()
            }
        }) {
        text(Modifier.platformModify { attrsModifier { slot(MdMenuItemScope.Slot.Headline) } })
        leadingIcon?.let { it(Modifier.platformModify { attrsModifier { slot(MdMenuItemScope.Slot.Start) } }) }
        trailingIcon?.let { it(Modifier.platformModify { attrsModifier { slot(MdMenuItemScope.Slot.End) } }) }
    }

