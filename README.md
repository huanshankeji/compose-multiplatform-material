# Compose Multiplatform Material wrappers for `androidx.compose.material` and Compose HTML

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-multiplatform-material)](https://search.maven.org/search?q=g:com.huanshankeji%20AND%20a:compose-multiplatform-*)
![Kotlin version](https://kotlin-version.aws.icerock.dev/kotlin-version?group=com.huanshankeji&name=compose-multiplatform-material)

Some simple unified Compose Multiplatform wrappers of common components, layouts, and Material Design components for `androidx.compose.material` (officially supported on Android, desktop (JVM), iOS, web (Kotlin/Wasm)) and Compose HTML (mainly based on [KMDC](https://github.com/mpetuska/kmdc))

<!-- a set of APIs for Compose HTML similar to those in `androidx.compose.material` -->

We try to make the function types of the composable components follow those in `androidx.compose.foundation` and `androidx.compose.material`, meanwhile being compatible with the Compose HTML APIs. However, only subsets of the composables and composable arguments are supported due to the API differences, limitations of the Compose HTML composables this project depends on, and our limited effort.

Visual consistency across different platforms is not guaranteed.

This project is prototype and there is no documentation yet. Check out [the demo project](demo) on how to use the components.

## Supported features

### Components

#### Common (Foundation) components

- `BasicText`
- `RawText`

##### Layouts

- `Box`
- `Column` (via flexbox on web)
- `Row` (via flexbox on web)

#### Material components

- `Button`
- `Card`
- `Icon`
- `IconButton`
- `ScrollableList`/`LazyColumn` (visually inconsistent for now)
- `Text`/`MaterialText`
- `TextField`
- `TopAppBarScaffold`

### Styles

The `ModifierOrAttrsScope.styles` function and the `StyleScope` class provide a universal interface for `Modifier`s and CSS styles.

The functions in `StyleScope`:

- `height`
- `margin`
- `width`
- `backgroundColor`
- `platformBorder`
- `outerBorder`
