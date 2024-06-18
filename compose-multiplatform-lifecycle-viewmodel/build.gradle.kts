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
                https://github.com/JetBrains/compose-multiplatform-core/blob/jb-main/lifecycle/lifecycle-viewmodel-compose/build.gradle
                https://android.googlesource.com/platform/frameworks/support/+/refs/heads/androidx-main/lifecycle/lifecycle-viewmodel-compose/build.gradle
                */
                api(compose.runtime)
                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel:${DependencyVersions.composeMultiplatformLifecycleViewmodel}")
            }
        }
        androidxCommonMain {
            dependencies {
                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:${DependencyVersions.composeMultiplatformLifecycleViewmodel}")
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Unified Compose Multiplatform ViewModel $FOR_COMPOSE_TARGETS_IN_TITLE",
        "Unified wrappers of Compose Multiplatform ViewModel for $FOR_COMPOSE_TARGETS_IN_DESCRIPTION"
    ) {
        `Shreck Ye`()
    }
}
