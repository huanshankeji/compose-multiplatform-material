# Compose Multiplatform Material wrappers

Some simple Compose Multiplatform Material Design component wrappers for desktop, Android, and web (mainly based on [KMDC](https://github.com/mpetuska/kmdc))

We try to make the styles of the composable components follow those of the desktop and Android ones in `com.huanshankeji.compose.material`, meanwhile being compatible with the Web APIs. However, only a subset of the composable arguments is supported due to the API differences and limitations of the web composables this project depends on.

Customizing styles (using `Modifier`s for desktop and Android, and `attrs: AttrBuilderContext<*>?` for web) is not supported yet.

Visual consistency across different platforms is not guaranteed.

## Supported components

- `Button`
- `TopAppBarScaffold`
