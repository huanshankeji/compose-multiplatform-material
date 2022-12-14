import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                api(project(":compose-multiplatform-common"))
                //compileOnly(compose.material) // for KDoc element links only
            }
        }
        // TODO: a `jvmCommon` source set to share code for `jvm`/`desktop` and `android`
        named("jvmMain") {
            dependencies {
                //implementation(compose.foundation) // not needed
                implementation(compose.material)
            }
        }
        named("jsMain") {
            dependencies {
                // copied from https://github.com/mpetuska/kmdc

                // Be lazy and use the shortcut
                implementation("dev.petuska:kmdc:0.0.5")
                implementation("dev.petuska:kmdcx:0.0.5")
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
