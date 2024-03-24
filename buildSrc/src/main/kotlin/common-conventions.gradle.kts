import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

group = "com.huanshankeji"
version = "0.1.3-SNAPSHOT"

kotlin {
    // for `androidx.compose`

    jvm() // TODO: `jvm("desktop")`?
    jvmToolchain(8)

    //androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs()


    // for JS and HTML wrappers

    js()
}
