plugins {
    `common-conventions`
    // TODO: `id("com.android.library") version "7.2.2"`?
    id("com.huanshankeji.kotlin-multiplatform-jvm-and-js-browser-sonatype-ossrh-publish-conventions")
}

group = "com.huanshankeji"
version = "0.1.0-SNAPSHOT"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }
        // TODO: a `jvmCommon` source set to share code for `jvm`/`desktop` and `android`
        named("jvmMain") {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }
        named("jsMain") {
            dependencies {
                // copied from https://github.com/mpetuska/kmdc

                // Be lazy and use the shortcut
                implementation("dev.petuska:kmdc:0.0.5")
                implementation("dev.petuska:kmdcx:0.0.5")
                // TODO: pick and choose exact components to reduce bundle size

                // SCSS dependencies
                implementation(devNpm("style-loader", "^3.3.1"))
                implementation(devNpm("css-loader", "^6.7.1"))
                implementation(devNpm("sass-loader", "^13.0.0"))
                implementation(devNpm("sass", "^1.52.1"))
            }
        }
    }
}
