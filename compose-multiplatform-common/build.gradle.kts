plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                compileOnly(compose.foundation) // for KDoc element links only
            }
        }
        named("jvmMain") {
            dependencies {
                implementation(compose.foundation)
            }
        }
        named("jsMain") {
            dependencies {
                implementation(compose.web.core)

                api("com.huanshankeji:compose-web-common:${DependencyVersions.huanshankejiComposeWeb}")
            }
        }
    }
}
