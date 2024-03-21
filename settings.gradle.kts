rootProject.name = "compose-multiplatform-material"
include("compose-multiplatform-common") // TODO consider renaming into "foundation"
include("compose-multiplatform-material")
include("demo")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
