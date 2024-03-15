# Compose Multiplatform Material wrappers

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-multiplatform-material)](https://search.maven.org/artifact/com.huanshankeji/compose-multiplatform-material)
![Kotlin version](https://kotlin-version.aws.icerock.dev/kotlin-version?group=com.huanshankeji&name=compose-multiplatform-material)

Some simple Compose Multiplatform wrappers of common components, layouts, and Material Design components for Android/desktop/iOS (those in `androidx.compose.material`) and Compose HTML (mainly based on [KMDC](https://github.com/mpetuska/kmdc))

We try to make the function types of the composable components follow those of the desktop and Android ones
in `androidx.compose.foundation` and `androidx.compose.material`, meanwhile being compatible with the Compose HTML APIs. However,
only subsets of the composables and composable arguments are supported due to the API differences, limitations of the
Compose HTML composables this project depends on, and our limited effort.

Visual consistency across different platforms is not guaranteed.

This project is prototype and there is no documentation yet. Check out [the demo project](demo) on how to use the components.

<!--
There is no plan to support Apple platforms until there is official support from [Compose Multiplatform](https://github.com/JetBrains/compose-jb). Check out <https://github.com/cl3m/multiplatform-compose> for some experiments and prototypes on supporting iOS with Compose Multiplatform.
-->

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
