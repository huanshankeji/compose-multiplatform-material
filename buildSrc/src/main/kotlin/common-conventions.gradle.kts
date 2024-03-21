import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.huanshankeji"
version = "0.1.3-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    jvm() // TODO: `jvm("desktop")`?
    jvmToolchain(8)
    //androidTarget()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs()

    js()
}
