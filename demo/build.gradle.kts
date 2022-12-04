plugins {
    `common-conventions`
}

kotlin {
    js(IR) { browser() }

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(project(":compose-multiplatform-material"))
            }
        }
    }
}
