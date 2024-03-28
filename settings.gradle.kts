rootProject.name = "compose-multiplatform-material"

include("compose-multiplatform-common") // TODO consider splitting into several modules including `foundation`, `ui`, etc.
include("compose-multiplatform-common:legacy")
project(":compose-multiplatform-common:legacy").name = "compose-multiplatform-common-legacy"
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
