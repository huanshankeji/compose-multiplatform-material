import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                //compileOnly(compose.foundation) // for KDoc element links only
                /*
                The units from Compose are used directly.
                This is an ideal dependency whose APIs should be exposed and shared on all platforms including JS
                therefore we don't need to create wrappers for them,
                because a depending `ui-graphics` module would be too much as it depends on `skiko`,
                and more such as `ui` and `ui-text` depend on `ui-graphics`.
                A dependency of `ui-unit` is `ui-geometry` which might be useful too.
                */
                api("org.jetbrains.compose.ui:ui-unit:${DependencyVersions.composeMultiplatform}")
            }
        }
        androidxCommonMain {
            dependencies {
                implementation(compose.foundation)
            }
        }
        jsMain {
            dependencies {
                implementation(compose.html.core)

                // TODO or use `api`
                // TODO use the artifacts `silk-foundation` or `kobweb-compose` if they provide enough APIs already
                implementation("com.varabyte.kobweb:kobweb-silk:${DependencyVersions.kobweb}")
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
