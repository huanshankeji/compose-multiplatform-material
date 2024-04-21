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
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public") // for Kobweb
}

group = "com.huanshankeji"
version = projectVersion

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
