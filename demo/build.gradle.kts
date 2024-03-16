plugins {
    `common-conventions`
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport { enabled.set(true) }
                scssSupport { enabled.set(true) }
                outputFileName = "app.js"
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
        jsMain {
            dependencies {
                implementation(compose.html.core)

                implementation(npm("material-icons", DependencyVersions.materialIcons))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.huanshankeji.compose.material.demo.MainKt"
    }
}
