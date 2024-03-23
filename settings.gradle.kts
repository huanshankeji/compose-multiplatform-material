rootProject.name = "compose-multiplatform-material"

include("compose-multiplatform-common") // TODO consider renaming into "foundation"
include("compose-multiplatform-material")
include("demo")


pluginManagement {
    repositories {
        //mavenLocal()
        gradlePluginPortal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
