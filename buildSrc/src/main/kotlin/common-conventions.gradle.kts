import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.huanshankeji"
version = "0.1.3-SNAPSHOT"

kotlin {
    jvm() // TODO: `jvm("desktop")`?
    jvmToolchain(8)

    //androidTarget()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs()

    iosX64()
    iosArm64()
    iosSimulatorArm64()


    js()
}
