plugins {
    `common-conventions`
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
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
                /* TODO: uncomment or remove
                // copied from https://github.com/mpetuska/kmdc

                // SCSS dependencies
                implementation(devNpm("style-loader", "^3.3.1"))
                implementation(devNpm("css-loader", "^6.7.1"))
                implementation(devNpm("sass-loader", "^13.0.0"))
                implementation(devNpm("sass", "^1.52.1"))
                */


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
