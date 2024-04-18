package com.huanshankeji.compose.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.ui.Modifier
import androidx.compose.material.ExperimentalMaterialApi as PlatformExperimentalMaterialApi

// https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#ExposedDropdownMenuBox(kotlin.Boolean,kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Function1)

@ExperimentalMaterialApi
@OptIn(PlatformExperimentalMaterialApi::class)
@Composable
actual fun ExposedDropdownMenuBox(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier,
    content: @Composable ExposedDropdownMenuBoxScope.() -> Unit
) =
    androidx.compose.material.ExposedDropdownMenuBox(expanded, onExpandedChange, modifier.platformModifier) {
        ExposedDropdownMenuBoxScope(this).content()
    }

@ExperimentalMaterialApi
@OptIn(PlatformExperimentalMaterialApi::class)
actual class ExposedDropdownMenuBoxScope(val platformValue: androidx.compose.material.ExposedDropdownMenuBoxScope)
