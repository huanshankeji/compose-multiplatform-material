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
                api(project(":compose-multiplatform-common"))
                //compileOnly(compose.material) // for KDoc element links only
            }
        }
        // TODO: a `jvmCommon` source set to share code for `jvm`/`desktop` and `android`
        jvmMain {
            dependencies {
                //implementation(compose.foundation) // not needed
                implementation(compose.material)
            }
        }
        jsMain {
            dependencies {
                // copied from https://github.com/mpetuska/kmdc

                // Be lazy and use the shortcut
                implementation("dev.petuska:kmdc:${DependencyVersions.kmdc}")
                implementation("dev.petuska:kmdcx:${DependencyVersions.kmdc}")
                // TODO: pick and choose exact components to reduce bundle size
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose Multiplatform Material wrappers",
        "Material Design component wrappers for Compose Multiplatform (desktop/Android and web)"
    ) {
        `Shreck Ye`()
    }
}
