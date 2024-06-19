package com.huanshankeji.compose.foundation

import com.huanshankeji.compose.ui.Modifier

/**
 * Delegates to `clickable` on Android. `onClick` is not available on Android. See https://github.com/JetBrains/compose-multiplatform/issues/4468 for details.
 */
@ExperimentalFoundationApi
expect fun Modifier.onClick(onClick: () -> Unit): Modifier
