package com.huanshankeji.androidx.lifecycle.viewmodel.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
actual inline fun <reified VM : ViewModel> viewModel(noinline initializer: CreationExtras.() -> VM): VM =
    viewModel(initializer = initializer)
