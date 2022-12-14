# Compose Multiplatform Material wrappers

Some simple Compose Multiplatform Material Design component wrappers for desktop, Android, and web (mainly based on [KMDC](https://github.com/mpetuska/kmdc))

We try to make the styles of the composable components follow those of the desktop and Android ones in `com.huanshankeji.compose.material`, meanwhile being compatible with the Web APIs. However, only a subset of the composable arguments is supported due to the API differences and limitations of the web composables this project depends on.

Visual consistency across different platforms is not guaranteed.

This project is prototype and there is no documentation yet. Check out [the demo project](demo) on how to use the components.

There is no plan to support Apple platforms until there is official support from [Compose Multiplatform](https://github.com/JetBrains/compose-jb). Check out <https://github.com/cl3m/multiplatform-compose> for some experiments and prototypes on supporting iOS with Compose Multiplatform.

## Supported components

### Common (Foundation) components

- `BasicText`
- `RawText`

#### Layouts

- `Box`
- `Column`
- `Row`

### Material components

- `Button`
- `Card`
- `Icon`
- `IconButton`
- `List`/`LazyColumn` (visually inconsistent)
- `Text`/`MaterialText`
- `TopAppBarScaffold`
