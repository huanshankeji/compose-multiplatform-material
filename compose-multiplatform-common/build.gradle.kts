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
            }
        }
    }
}
