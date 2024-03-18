plugins {
    `common-conventions`
}

kotlin {
    val outputFileName = "app.js"
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
        jsMain {
            dependencies {
                implementation(compose.html.core)

                implementation(npm("material-icons", DependencyVersions.materialIcons))
            }
        }
    }
}

compose {
    desktop {
        application {
            mainClass = "com.huanshankeji.compose.material.demo.MainKt"
        }
    }

    experimental {
        web.application {}
    }
}
