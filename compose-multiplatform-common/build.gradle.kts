import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                //compileOnly(compose.foundation) // for KDoc element links only
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

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose Multiplatform common wrappers",
        "Common wrappers of components (including layouts) and styles for Compose Multiplatform on (desktop/Android and web)"
    ) {
        `Shreck Ye`()
    }
}
