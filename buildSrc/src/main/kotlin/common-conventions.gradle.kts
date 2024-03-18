import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    jvm() // TODO: `jvm("desktop")`?
    // TODO: `android()`?
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs()

    js()
}
