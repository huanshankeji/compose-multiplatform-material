package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier

// https://github.com/mpetuska/kmdc/blob/master/sandbox/src/jsMain/showcases/MDCMenu.kt

@ExperimentalMaterialApi
@Composable
actual fun ExposedDropdownMenuBox(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier,
    content: @Composable ExposedDropdownMenuBoxScope.() -> Unit
) =
    TODO() as Unit

@ExperimentalMaterialApi
actual class ExposedDropdownMenuBoxScope
