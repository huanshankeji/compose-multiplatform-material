import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    `common-conventions`
}

kotlin {
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
