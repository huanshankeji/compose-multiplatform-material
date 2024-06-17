import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    `common-conventions`
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    val outputFileName = "app.js"

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                this.outputFileName = outputFileName
            }
        }
        binaries.executable()
    }

    js {
        browser {
            commonWebpackConfig {
                this.outputFileName = outputFileName
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(project(":compose-multiplatform-navigation"))
                implementation(project(":compose-multiplatform-common"))
                //implementation("org.jetbrains.androidx.navigation:navigation-compose:${DependencyVersions.composeMultiplatformNavigation}")
            }
        }
        jvmMain {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        iosMain {
            dependencies {
                implementation(compose.ui)
            }
        }
        wasmJsMain {
            dependencies {
                implementation(compose.ui)
            }
        }
    }
}

val `package` = "$group.androidx.navigation.compose.bug"

compose {
    desktop {
        application {
            mainClass = "$`package`.MainKt"
        }
    }
}
