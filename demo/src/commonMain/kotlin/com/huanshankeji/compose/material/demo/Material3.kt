package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.ExtRecommendedApi
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.foundation.text.KeyboardActions
import com.huanshankeji.compose.foundation.text.KeyboardOptions
import com.huanshankeji.compose.foundation.text.input.ImeAction
import com.huanshankeji.compose.foundation.text.input.KeyboardCapitalization
import com.huanshankeji.compose.foundation.text.input.KeyboardType
import com.huanshankeji.compose.layout.height
import com.huanshankeji.compose.material.icons.Icons
import com.huanshankeji.compose.material.icons.filled.Add
import com.huanshankeji.compose.material.icons.filled.Menu
import com.huanshankeji.compose.material.icons.filled.Remove
import com.huanshankeji.compose.material3.*
import com.huanshankeji.compose.material3.ext.*
import com.huanshankeji.compose.material3.lazy.ext.List
import com.huanshankeji.compose.material3.lazy.ext.ListItemComponents
import com.huanshankeji.compose.ui.Modifier
import com.huanshankeji.compose.material3.Button as RowScopeButton

@Composable
fun Material3() {
    Column {
        var count by remember { mutableStateOf(0) }
        val onClick: () -> Unit = { count++ }
        val buttonContent: @Composable () -> Unit = {
            InlineText(count.toString())
        }
        val rowScopeButtonContent: @Composable RowScope.() -> Unit = { buttonContent() }
        Row {
            RowScopeButton(onClick, content = rowScopeButtonContent)
            Button(onClick, content = buttonContent)
            ElevatedButton(onClick, content = buttonContent)
            FilledTonalButton(onClick, content = buttonContent)
            OutlinedButton(onClick, content = buttonContent)
            TextButton(onClick, content = buttonContent)
        }
        Row {
            ButtonWithMaterialIcon(onClick, icon = Icons.Default.Add, content = buttonContent)
            ButtonWithMaterialIcon(onClick, icon = Icons.Default.Add, isTrailingIcon = true, content = buttonContent)
        }
        val iconButtonContent: @Composable () -> Unit = {
            Icon(Icons.Default.Add, null)
        }
        Row {
            IconButton(onClick, content = iconButtonContent)
            FilledIconButton(onClick, content = iconButtonContent)
            FilledTonalIconButton(onClick, content = iconButtonContent)
            OutlinedIconButton(onClick, content = iconButtonContent)
        }
        val (checked, onCheckedChange) = remember { mutableStateOf(false) }
        val iconToggleButtonContent: @Composable () -> Unit = {
            Icon(if (checked) Icons.Default.Add else Icons.Default.Remove, null)
        }
        @OptIn(ExtRecommendedApi::class)
        Row {
            IconToggleButton(checked, onCheckedChange, content = iconToggleButtonContent)
            FilledIconToggleButton(checked, onCheckedChange, content = iconToggleButtonContent)
            FilledTonalIconToggleButton(checked, onCheckedChange, content = iconToggleButtonContent)
            OutlinedIconToggleButton(checked, onCheckedChange, content = iconToggleButtonContent)
        }
        Row {
            IconToggleButtonWithMaterialIcons(
                checked, onCheckedChange,
                uncheckedIcon = Icons.Default.Remove, checkedIcon = Icons.Default.Add
            )
            FilledIconToggleButtonWithMaterialIcons(
                checked, onCheckedChange,
                uncheckedIcon = Icons.Default.Remove, checkedIcon = Icons.Default.Add
            )
            FilledTonalIconToggleButtonWithMaterialIcons(
                checked, onCheckedChange,
                uncheckedIcon = Icons.Default.Remove, checkedIcon = Icons.Default.Add
            )
            OutlinedIconToggleButtonWithMaterialIcons(
                checked, onCheckedChange,
                uncheckedIcon = Icons.Default.Remove, checkedIcon = Icons.Default.Add
            )
        }
        @OptIn(ExtRecommendedApi::class)
        Row {
            FloatingActionButton(onClick, content = iconButtonContent)
            SmallFloatingActionButton(onClick, content = iconButtonContent)
            LargeFloatingActionButton(onClick, content = iconButtonContent)
            ExtendedFloatingActionButton(onClick) {
                iconButtonContent()
                Text("Add")
            }
        }
        Row {
            FloatingActionButtonWithMaterialIcon(onClick, icon = Icons.Default.Add)
            SmallFloatingActionButtonWithMaterialIcon(onClick, icon = Icons.Default.Add)
            LargeFloatingActionButtonWithMaterialIcon(onClick, icon = Icons.Default.Add)
            ExtendedFloatingActionButtonWithMaterialIcon(onClick, label = "Add", icon = Icons.Default.Add)
        }
        Row {
            Checkbox(checked, onCheckedChange)
            Switch(checked, onCheckedChange)
        }

        var text by remember { mutableStateOf("") }
        val label = "label"
        val placeholder = "placeholder"
        val prefix = "prefix"
        val suffix = "suffix"
        val supportingText = "supporting text"
        TextFieldWithMaterialIcons(
            text,
            { text = it },
            label = label,
            placeholder = placeholder,
            leadingIcon = Icons.Default.Add,
            trailingIcon = Icons.Default.Menu,
            prefix = prefix,
            suffix = suffix,
            supportingText = supportingText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextFieldWithMaterialIcons(
            text,
            { text = it },
            label = label,
            placeholder = placeholder,
            leadingIcon = Icons.Default.Add,
            trailingIcon = Icons.Default.Menu,
            prefix = prefix,
            suffix = suffix,
            supportingText = supportingText,
            keyboardOptions = KeyboardOptions(
                KeyboardCapitalization.Words, true, imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions {
                println("keyboard actions with: $text")
            }
        )

        Text("Click a button to show the list:")
        List(Modifier.height(listSize)) {
            fun content(index: String) =
                ListItemComponents(
                    Modifier,
                    "Headline $index",
                    Icons.Default.Add,
                    Icons.Default.Menu,
                    "Supporting text $index",
                    "Trailing supporting text $index",
                    "Overline $index"
                )
            conventionalItem(content = content(""))
            conventionalItems(count) { index ->
                content(index.toString())
            }
        }
    }
}
