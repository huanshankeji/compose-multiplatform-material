import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    `common-conventions`
    id("com.android.application")
}

kotlin {
    androidTarget()

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
                cssSupport { enabled.set(true) }
                scssSupport { enabled.set(true) }
                this.outputFileName = outputFileName
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(project(":compose-multiplatform-material"))
                implementation(project(":compose-multiplatform-material3"))
            }
        }
        jvmMain {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        androidMain {
            dependencies {
                // TODO consider putting this in `androidxCommonMain`
                implementation(compose.ui)

                implementation("androidx.activity:activity-compose:${DependencyVersions.Androidx.activityCompose}")
                implementation("androidx.compose.ui:ui-tooling-preview:${DependencyVersions.Androidx.compose}")
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
        jsMain {
            dependencies {
                implementation(compose.html.core)
                implementation(npm("material-symbols", "0.17.4"))
            }
        }
    }
}

val `package` = "$group.compose.material.demo"

compose {
    desktop {
        application {
            mainClass = "$`package`.MainKt"
        }
    }

    experimental {
        web.application {}
    }
}

android {
    namespace = `package`

    val sdk = 34
    compileSdk = sdk

    defaultConfig {
        applicationId = `package`
        minSdk = 24
        targetSdk = sdk
        versionName = version as String
    }
}
