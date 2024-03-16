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
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(project(":compose-multiplatform-material"))
            }
        }
        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        named("jsMain") {
            dependencies {
                implementation(compose.html.core)

                implementation(npm("material-icons", "1.13.1"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.huanshankeji.compose.material.demo.MainKt"
    }
}
