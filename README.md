# Compose Multiplatform Material wrappers for `androidx.compose.material` and Compose HTML

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-multiplatform-material)](https://search.maven.org/search?q=g:com.huanshankeji%20AND%20a:compose-multiplatform-*)
![Kotlin version](https://kotlin-version.aws.icerock.dev/kotlin-version?group=com.huanshankeji&name=compose-multiplatform-material)

Some simple unified Compose Multiplatform wrappers of common components, layouts, and Material Design components for `androidx.compose.material` (officially supported on Android, desktop (JVM), iOS, web (Kotlin/Wasm)) and Compose HTML (mainly based on [Kobweb Silk](https://github.com/varabyte/kobweb?tab=readme-ov-file#silk) and [KMDC](https://github.com/mpetuska/kmdc))

<!-- a set of APIs for Compose HTML similar to those in `androidx.compose.material` -->

We try to make the function types of the composable components follow those in `androidx.compose.foundation` and `androidx.compose.material`, meanwhile being compatible with the Compose HTML APIs. However, only subsets of the composables and composable arguments are supported due to the API differences, limitations of the Compose HTML composables this project depends on, and our limited effort.

Visual consistency across different platforms is not guaranteed.

This project is prototype and there is no documentation yet. Check out [the demo project](demo) on how to use the components.

## Supported features

### Components

#### Common (Foundation) components

- `BasicText`

##### `ext` components

- `InlineBasicText`

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

#### Components in the `ext` packages

The components in the `ext` packages don't follow the `androidx.compose` APIs exactly, but rather provide wrappers are idiomatic and conventional on both kinds of targets, wrapping different APIs which can't be unified following the `androidx.compose` APIs.

### Styles (obsolete in the legacy module, for removal)

The `ModifierOrAttrsScope.styles` function and the `StyleScope` class provide a universal interface for `Modifier`s and CSS styles.

The functions in `StyleScope`:

- `height`
- `margin`
- `width`
- `backgroundColor`
- `platformBorder`
- `outerBorder`

### Modifiers

- size modifiers
   - `size`, `sizeIn`, `fillMaxSize`
   - `width`, `widthIn`, `fillMaxWidth`
   - `height`, `heightIn`, `fillMaxHeight`
- `padding`
- `background`
- `border` (visually inconsistent)

#### `ext` modifiers

- `outerBorder`
- `roundedCornerBackgroundAndOuterBorder`

## Add the libraries to your dependency

Maven coordinate:

```kotlin
"com.huanshankeji:compose-multiplatform-$module:$version"
```

View [all the artifacts on Maven Central](https://search.maven.org/search?q=g:com.huanshankeji%20AND%20a:compose-multiplatform-*).

This project depends on [Kobweb](https://github.com/varabyte/kobweb) which is not published to Maven Central yet, so you have to add the following Maven repository:

```kotlin
repositories {
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
}
```

## About Kobweb Silk

The Kotlin/JS (Compose HTML) portion of this project depends on [Kobweb Compose](https://github.com/varabyte/kobweb/blob/main/frontend/kobweb-compose/README.md) of [Kobweb Silk](https://github.com/varabyte/kobweb?tab=readme-ov-file#silk) which is a UI layer built upon Compose HTML that provides `Modifier` APIs (type-safe CSS API wrappers) and layouts. Here is a list of topics in their README.md that should be helpful when you use this library in Compose HTML:

1. [Silk](https://github.com/varabyte/kobweb?tab=readme-ov-file#silk)
   1. [Modifier](https://github.com/varabyte/kobweb?tab=readme-ov-file#modifier) 
      1. [attrsModifier and styleModifier](https://github.com/varabyte/kobweb?tab=readme-ov-file#attrsmodifier-and-stylemodifier) 
1. [General purpose improvements on top of Compose HTML and Kotlin/JS](https://github.com/varabyte/kobweb?tab=readme-ov-file#general-purpose-improvements-on-top-of-compose-html-and-kotlinjs)
1. [What about Compose Multiplatform for Web?](https://github.com/varabyte/kobweb?tab=readme-ov-file#what-about-compose-multiplatform-for-web)
