plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
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
