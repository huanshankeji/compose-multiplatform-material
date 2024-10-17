plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal() // TODO comment out when not needed
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    // With Kotlin 2.0.20, a "Could not parse POM" build error occurs in the JVM projects of some dependent projects.
    val kotlinVersion = "2.0.10"
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.7.0")
    implementation("com.huanshankeji.team:gradle-plugins:0.6.0-SNAPSHOT") // TODO don't use a snapshot version in a main branch
    implementation("com.android.tools.build:gradle:8.5.2")
    implementation("com.huanshankeji:common-gradle-dependencies:0.7.2-20241016-SNAPSHOT") // TODO don't use a snapshot version in a main branch
}
