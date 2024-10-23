# Change log

## v0.4.0 / 2024-10-24

* revamp Material 2 `TopAppBarScaffold` to take a bottom bar, a floating action bottom, and a snackbar host, and fix some of its display issues on JS DOM
  * fix bugs that the action buttons don't show and their `onClick` callbacks are not passed on JS DOM
* add the Material 3 menu composables `DropdownMenu`, `DropdownMenuItem`, `ExposedDropdownMenuBox`, and `ExposedDropdownMenuWithTextField`
* add the Material 3 progress indicator composables `LinearProgressIndicator` and `CircularProgressIndicator`
* add the Material 2 `SnackbarHost` (the Material 3 snackbar is not available in Material Web yet)
* add `Arrangement.spacedBy`
* Move `LoadingState` here from [Compose HTML Material](https://github.com/huanshankeji/compose-html-material)
* add color parameters to the text composables
* rename `InlineText` to `TaglessText`
* add the `alpha` modifiers
* add a `hidden` modifier
* fix a bug in the Material 3 text fields on JS DOM that causes the caret to be reset to the start whenever the value changes if the `type` attribute is set
* initially support navigation
* initially support ViewModels which delegates to raw UI state on Compose HTML / JS DOM
* fix a bug that the Android demo app might crash and add the Android target explicitly for all modules
* add the `clickable` modifier and replace `onClick` with it
* add `RadioGroupColumn` and improve `RadioRow` on JS DOM
* add a platform-specific implementation for `com.huanshankeji.compose.material2.ext.IconButton` on JS DOM that's more idiomatic, and fix a bug that in some scenarios icons are not shown, by always importing "material-icons/iconfont/material-icons.css"
* add the `PaddingValues` type
* make multiline text fields work on JS DOM
* add an `isInteractiveJs` parameter to ListItemComponents
* add a `BoxWithConstraints` layout composable that's still buggy on JS DOM
* no longer publish the legacy module
* Add `flex-basis: 0` to the weight modifiers on JS DOM to be consistent with the `androidx.compose` behavior
* make the demo UI fridendly on mobile
* Split the `padding` modifiers into `outerPadding` and `innerPadding`
* add the `VerticalScrollBox` and `HorizontalScrollBox` composables as (better) alternatives to the `*Scroll` modifiers

* bump Kotlin to 2.0.10, Compose Multiplatform to 1.7.0, Kobweb to 0.19.2, and our Compose HTML Material to 0.4.0
