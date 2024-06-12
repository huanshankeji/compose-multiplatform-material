import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
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
        "Unified Compose Multiplatform navigaton $FOR_COMPOSE_TARGETS_IN_TITLE",
        "Unified wrappers of Compose Multiplatform navigaton for $FOR_COMPOSE_TARGETS_IN_DESCRIPTION"
    ) {
        `Shreck Ye`()
    }
}
