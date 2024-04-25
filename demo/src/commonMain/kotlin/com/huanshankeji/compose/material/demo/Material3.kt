package com.huanshankeji.compose.material.demo

import androidx.compose.runtime.*
import com.huanshankeji.compose.foundation.layout.Column
import com.huanshankeji.compose.foundation.layout.Row
import com.huanshankeji.compose.foundation.layout.RowScope
import com.huanshankeji.compose.foundation.text.ext.InlineBasicText
import com.huanshankeji.compose.material3.Checkbox
import com.huanshankeji.compose.material3.ext.*
import com.huanshankeji.compose.material3.Button as RowScopeButton

@Composable
fun Material3() {
    Column {
        var count by remember { mutableStateOf(0) }
        val onClick: () -> Unit = { count++ }
        val buttonContent: @Composable () -> Unit = {
            InlineBasicText(count.toString()) // TODO use `com.huanshankeji.compose.material3.ext.InlineText`
        }
        val rowScopeButtonContent: @Composable RowScope.() -> Unit = { buttonContent() }
        val buttonScopeButtonContent: @Composable ButtonScope.() -> Unit = { buttonContent() }
        Row {
            RowScopeButton(onClick, content = rowScopeButtonContent)
            Button(onClick, content = buttonScopeButtonContent)
            ElevatedButton(onClick, content = buttonScopeButtonContent)
            FilledTonalButton(onClick, content = buttonScopeButtonContent)
            OutlinedButton(onClick, content = buttonScopeButtonContent)
            TextButton(onClick, content = buttonScopeButtonContent)
        }

        Row {
            var checked by remember { mutableStateOf(false) }
            Checkbox(checked, { checked = it })
            Checkbox(checked, { checked = it })
        }
    }
}
