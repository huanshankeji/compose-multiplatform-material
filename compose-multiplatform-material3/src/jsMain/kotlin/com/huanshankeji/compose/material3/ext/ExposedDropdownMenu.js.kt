package com.huanshankeji.compose.material3.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.huanshankeji.compose.material.icons.Icons
import com.huanshankeji.compose.material.icons.filled.ArrowDropDown
import com.huanshankeji.compose.material3.Icon
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.ui.draw.rotate
import com.huanshankeji.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement

@Composable
actual fun ExposedDropdownMenuBox(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier,
    content: @Composable ExposedDropdownMenuBoxScope.() -> Unit
) =
    Div({
        // see https://github.com/material-components/material-web/blob/main/docs/components/menu.md#usage
        style {
            position(Position.Relative)
        }
        modifier.toAttrs<AttrsScope<*>>()()
    }) {
        ExposedDropdownMenuBoxScope(remember { mutableStateOf(null) }, expanded, onExpandedChange).content()
    }

actual class ExposedDropdownMenuBoxScope(
    val anchorElementState: MutableState<HTMLElement?>, val expanded: Boolean, val onExpandedChange: (Boolean) -> Unit
) {
    /*
    companion object {
        const val ANCHOR_ID = "anchor"
    }
    */

    actual fun Modifier.menuAnchor(): Modifier =
        platformModify {
            attrsModifier {
                //id(ANCHOR_ID) // An alternative approach by setting IDs. Duplicate IDs are semantically incorrect, however.

                ref {
                    anchorElementState.value = it as HTMLElement
                    onDispose { anchorElementState.value = null }
                }
                // only fired when `expanded` set to `true` to be consistent with the `androidx.compose` one behavior
                if (!expanded)
                    onClick {
                        onExpandedChange(true)
                    }
            }
        }

    /**
     * @param onDismissRequestAndroidxCommonOnly not supported on JS.
     * @param onCloseJsOnly JS only.
     */
    @Composable
    actual fun ExposedDropdownMenu(
        expanded: Boolean,
        onDismissRequestAndroidxCommonOnly: () -> Unit,
        onCloseJsOnly: () -> Unit,
        modifier: Modifier,
        content: @Composable () -> Unit
    ) =
        CommonDropdownMenu(
            //ANCHOR_ID, // An alternative approach by setting IDs. Duplicate IDs are semantically incorrect, however.
            expanded,
            onCloseJsOnly,
            {
                ref {
                    anchorElementState.value?.let { anchorElement -> it.anchorElement = anchorElement }
                    onDispose {}
                }

                modifier.platformModifier.toAttrs<AttrsScope<*>>()()
            },
            content = { content() }
            //onExpandedChange = onExpandedChange // It seems there's no need to pass here as `onExpandedChange` will be called when clicking the text view
        )
}

@Composable
actual fun ExposedDropdownMenuBoxScope.ExposedDropdownMenuBoxTextField(
    expanded: Boolean, args: ExposedDropdownMenuBoxTextFieldArgs
) =
    with(args) {
        // adapted from the `androidxCommon` one
        TextField(
            modifier = Modifier.menuAnchor(/*MenuAnchorType.PrimaryNotEditable*/),
            value = value,
            onValueChange = onValueChange,
            readOnly = readOnly,
            singleLine = singleLine,
            label = label,
            trailingIcon = { modifier ->
                Icon(Icons.Filled.ArrowDropDown, null, if (expanded) modifier.rotate(180f) else modifier)
            }
        )
    }
