rootProject.name = "compose-multiplatform-material"
include("compose-multiplatform-material")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

buildscript {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.7.20"))
        classpath("com.huanshankeji.team:gradle-plugins:0.3.2") {
            exclude("org.jetbrains.kotlin")
        }
    }
}
