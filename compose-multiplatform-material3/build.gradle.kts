import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        /*
        Use `api`. See:
        https://github.com/JetBrains/compose-multiplatform-core/blob/jb-main/compose/material3/material3/build.gradle
        https://android.googlesource.com/platform/frameworks/support/+/refs/heads/androidx-main/compose/material3/material3/build.gradle
        */
        commonMain {
            dependencies {
                api(compose.runtime)
                api(project(":compose-multiplatform-common"))
                //compileOnly(compose.material) // for KDoc element links only
            }
        }
        androidxCommonMain {
            dependencies {
                api(compose.material3)
            }
        }
        jsMain {
            dependencies {
                api("com.huanshankeji:compose-html-material3:${DependencyVersions.huanshankejiComposeHtml}")
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose Multiplatform Material 3 wrappers",
        "Compose Multiplatform Material Design 3 component wrappers for `androidx.compose` and Compose HTML"
    ) {
        `Shreck Ye`()
    }
}
