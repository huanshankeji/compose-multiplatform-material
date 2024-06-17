rootProject.name = "compose-multiplatform-material"

include("compose-multiplatform-common") // TODO consider splitting into several modules including `foundation`, `ui`, etc.
include("compose-multiplatform-common:legacy")
project(":compose-multiplatform-common:legacy").name = "compose-multiplatform-common-legacy"
include("compose-multiplatform-material-icons-core")
include("compose-multiplatform-material2")
include("compose-multiplatform-material3")
include("compose-multiplatform-navigation")
include("demo")


/*
// This seems not needed.
pluginManagement {
    repositories {
        //mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
*/

// This is needed for Kotlin Native.
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}
