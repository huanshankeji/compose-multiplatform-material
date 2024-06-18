import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                /*
                Use `api`. See:
                https://github.com/JetBrains/compose-multiplatform-core/blob/jb-main/navigation/navigation-compose/build.gradle
                https://android.googlesource.com/platform/frameworks/support/+/refs/heads/androidx-main/navigation/navigation-compose/build.gradle
                */
                api(compose.runtime)
                api("org.jetbrains.androidx.navigation:navigation-runtime:${DependencyVersions.composeMultiplatformNavigation}")
                //implementation("org.jetbrains.compose.annotation-internal:annotation:${DependencyVersions.composeMultiplatform}")
                api(project(":compose-multiplatform-common")) // for `Modifier` and `Alignment`
                //implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0") // This depends on Compose target '[jscanvas]'.
            }
        }
        androidxCommonMain {
            dependencies {
                api("org.jetbrains.androidx.navigation:navigation-compose:${DependencyVersions.composeMultiplatformNavigation}")
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Unified Compose Multiplatform navigation $FOR_COMPOSE_TARGETS_IN_TITLE",
        "Unified wrappers of Compose Multiplatform navigation for $FOR_COMPOSE_TARGETS_IN_DESCRIPTION"
    ) {
        `Shreck Ye`()
    }
}
