import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

repositories {
    //mavenLocal() // commented out so the build is always reproducible by others // put back if needed when depending on a snapshot
    mavenCentral()
    google()
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


    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}
