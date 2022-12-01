plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.2.1"
    // TODO: `id("com.android.library") version "7.2.2"`?
    id("com.huanshankeji.kotlin-multiplatform-jvm-and-js-browser-sonatype-ossrh-publish-conventions")
}

group = "com.huanshankeji"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    jvm() // TODO: `jvm("desktop")`?
    // TODO: `android()`?
    js(IR) {
        browser()
    }

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
                // Be lazy and use the shortcut
                implementation("dev.petuska:kmdc:0.0.5")
                implementation("dev.petuska:kmdcx:0.0.5")
                // TODO: pick and choose exact components to reduce bundle size
            }
        }
    }
}
