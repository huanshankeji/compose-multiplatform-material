# Compose Multiplatform Material (better name pending): unified Compose Multiplatform common extensions and Material wrappers for `androidx.compose` and Compose HTML

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-multiplatform-material3)](https://search.maven.org/search?q=g:com.huanshankeji%20AND%20a:compose-multiplatform-*)
![Kotlin version](https://kotlin-version.aws.icerock.dev/kotlin-version?group=com.huanshankeji&name=compose-multiplatform-material3)

Unified Compose Multiplatform wrappers of common components, layouts, and Material Design components for `androidx.compose` (officially supported on Android, desktop (JVM), iOS, and web (Kotlin/Wasm)) and Compose HTML (mainly based on [Kobweb Silk](https://github.com/varabyte/kobweb?tab=readme-ov-file#silk) [Compose](https://github.com/varabyte/kobweb/tree/main/frontend/kobweb-compose), [KMDC](https://github.com/mpetuska/kmdc), and [Compose HTML Material](https://github.com/huanshankeji/compose-html-material) (which is then based on [Material Web](https://github.com/material-components/material-web)))

We try to provide a set of common extensions and composable component APIs akin to those in `androidx.compose` (`androidx.compose.foundation`, `androidx.compose.material`, and `androidx.compose.material3`), meanwhile making them compatible with the Compose HTML APIs. However, only subsets of the composables and composable parameters are supported due to the API differences, limitations of the JS (web) platform and the Compose HTML composables this project depends on, and our limited effort.

Complete visual consistency across different platforms is not guaranteed.

This project is still in development and has not reached the stable state yet. Some APIs are likely to be changed and there is no detailed documentation yet. Check out [the demo project](demo) on how to use the components in addition to the information below.

## Supported features

### Components

#### Foundation components

- `BasicText`

##### `ext` components

- `TaglessBasicText`

##### Layouts

- `Box` (based on Kobweb)
- `Column` (via flexbox on JS, based on Kobweb)
- `Row` (via flexbox on JS, based on Kobweb)
- `Spacer`

###### `ext` layouts

 - `BoxWithConstraints`

##### Lazy

- `LazyColumn` (via flexbox on JS, based on Kobweb)
- `LazyRow` (via flexbox on JS, based on Kobweb)

#### Material 2 components

- `Button`
- `Card`
- `Checkbox`
- `Divider` (not working properly on JS yet)
- `Icon`
- `IconButton`
- `Snackbar` (inconsistent, not recommended), `SnackBarHost` (recommended)
- `Switch`
- `Text`

##### `ext` components

- `Button`
- `IconButton`
- `RadioRow`, `RadioGroupRow`
- `SwitchWithLabel`
- `MaterialText`, `TaglessText`
- `TextField`, `OutlinedTextField`
- `TopAppBarScaffold`

##### `lazy.ext` components

- `List`/`LazyColumnList` (visually inconsistent for now)

#### Material 3 components

- `Button` (`FilledButton`), `ElevatedButton`, `FilledTonalButton`, `OutlinedButton`, `TextButton`
- `Card` (`FilledCard`), `ElevatedCard`, `OutlinedCard`
- `Checkbox`
- `FloatingActionButton`, `SmallFloatingActionButton`, `LargeFloatingActionButton`, `ExtendedFloatingActionButton`
- `Icon`
- `IconButton`, `IconToggleButton`, `FilledIconButton`, `FilledIconToggleButton`, `FilledTonalIconButton`, `FilledTonalIconToggleButton`, `OutlinedIconButton`, `OutlinedIconToggleButton`
- `LinearProgressIndicator`, `CircularProgressIndicator`
- `Switch`
- `Text`

##### `ext` components

- `Button` (`FilledButton`), `ElevatedButton`, `FilledTonalButton`, `OutlinedButton`, `TextButton`
- `Card` (`FilledCard`), `ElevatedCard`, `OutlinedCard`
- `DropdownMenu`, `DropdownMenuItem`
   - `ExposedDropdownMenuBox`, `ExposedDropdownMenuBoxScope.ExposedDropdownMenuBoxTextField`, `ExposedDropdownMenuBoxScope.ExposedDropdownMenu`, `ExposedDropdownMenuWithTextField`
- `FloatingActionButton`, `SmallFloatingActionButton`, `LargeFloatingActionButton`, `ExtendedFloatingActionButton`
- `IconButton`, `IconToggleButton`, `FilledIconButton`, `FilledIconToggleButton`, `FilledTonalIconButton`, `FilledTonalIconToggleButton`, `OutlinedIconButton`, `OutlinedIconToggleButton`
- `NavigationBar`, `NavigationBarItem`
- `MaterialText`, `TaglessText`
- `TextField`, `OutlinedTextField`

##### `lazy.ext` components

- `List`/`LazyColumnList` (slightly visually inconsistent)

#### About `ext` components (components in the `ext` packages)

The components in the `ext` packages don't follow the `androidx.compose` APIs exactly, but rather provide wrappers are more idiomatic and conventional on both kinds of targets, wrapping different APIs which can't be unified following the `androidx.compose` APIs.

#### About parameter names

The parameter names with suffixes such as "JsDom" or "AndroidxCommon" are platform-specific, and only apply on their respective platform(s), Compose HTML / JS DOM or
`androidx.compose` platforms.

#### Material Icons

The `com.huanshankeji.compose.material.icons.Icon` class delegates to both kinds of targets, but only a few Material Icons are added as PoC. You need to add your concrete icon implementations following the style of the existing ones in `com.huanshankeji.compose.material.icons` to use the icons you need. Track the progress of full icon support in [#4](/../../issues/4).

### Modifiers

- `alpha`
- size modifiers
  - `size`, `sizeIn`, `fillMaxSize`
  - `width`, `widthIn`, `fillMaxWidth`
  - `height`, `heightIn`, `fillMaxHeight`
- `padding`
- `background`
- `border` (visually inconsistent)
- `onClick`
- `verticalScroll`, `horizontalScroll` (`ScrollState` not supported on JS yet)

#### `ext` modifiers

- `outerBorder`
- `roundedCornerBackgroundAndOuterBorder`

### Other APIs

- `Alignment`
- `Arrangement`
- `KeyboardOptions`
- `KeyboardActions`
- `PaddingValues`

### ViewModel

The ViewModel module currently supports a small subset of the Compose ViewModel APIs, and delegates to raw UI state on
Compose HTML / JS DOM. These APIs are highly experimental now.

### Navigation

The navigation module currently supports a small subset of the Compose Navigation APIs, which does not support
transition or animation on Compose HTML / JS DOM. These APIs are also highly experimental now.
See [CMP-4966](https://youtrack.jetbrains.com/issue/CMP-4966) for a bug to avoid. Also, ViewModel-related functions
are not implemented yet on Compose HTML / JS DOM.

## Add the libraries to your dependency

Maven coordinate:

```kotlin
"com.huanshankeji:compose-multiplatform-$module:$version"
```

More specifically:
```kotlin
"com.huanshankeji:compose-multiplatform-common:$version"
"com.huanshankeji:compose-multiplatform-material-icons-core:$version"
"com.huanshankeji:compose-multiplatform-material2:$version"
"com.huanshankeji:compose-multiplatform-material3:$version"
```

For example, depend on the Material 3 module with Gradle:

```kotlin
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                // ...
                implementation("com.huanshankeji:compose-multiplatform-material3:$version")
            }
        }
    }
}
```

View [all the artifacts on Maven Central](https://search.maven.org/search?q=g:com.huanshankeji%20AND%20a:compose-multiplatform-*).

This project depends on [Kobweb](https://github.com/varabyte/kobweb) which is not published to Maven Central yet, so you have to add the following Maven repository:

```kotlin
repositories {
    mavenCentral()
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
}
```

### Material Symbols & Icons on JS

See [the corresponding section in Compose HTML Material](https://github.com/huanshankeji/compose-html-material?tab=readme-ov-file#material-symbols--icons) for configuring Material Icons on JS.

## About Kobweb Silk

The Kotlin/JS (Compose HTML) portion of this project depends on [Kobweb Compose](https://github.com/varabyte/kobweb/blob/main/frontend/kobweb-compose/README.md) of [Kobweb Silk](https://github.com/varabyte/kobweb?tab=readme-ov-file#silk) which is a UI layer built upon Compose HTML that provides `Modifier` (type-safe CSS API wrappers) and layout APIs. Here is a list of topics in their README.md that should be helpful when you use this library in Compose HTML, especially if you need to customize the components further on Kotlin/JS (Compose HTML):

1. [Silk](https://github.com/varabyte/kobweb?tab=readme-ov-file#silk)
   1. [Modifier](https://github.com/varabyte/kobweb?tab=readme-ov-file#modifier)
      1. [attrsModifier and styleModifier](https://github.com/varabyte/kobweb?tab=readme-ov-file#attrsmodifier-and-stylemodifier)
1. [General purpose improvements on top of Compose HTML and Kotlin/JS](https://github.com/varabyte/kobweb?tab=readme-ov-file#general-purpose-improvements-on-top-of-compose-html-and-kotlinjs)
1. [What about Compose Multiplatform for Web?](https://github.com/varabyte/kobweb?tab=readme-ov-file#what-about-compose-multiplatform-for-web)
