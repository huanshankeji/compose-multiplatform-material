plugins {
    `kotlin-dsl`
}

repositories {
    //mavenLocal()
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    // With Kotlin 2.0.20, a "Could not parse POM" build error occurs in the JVM projects of some dependent projects.
    val kotlinVersion = "2.0.10"
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.6.11")
    implementation("com.huanshankeji.team:gradle-plugins:0.5.1")
    implementation("com.android.tools.build:gradle:8.5.2")
    implementation("com.huanshankeji:common-gradle-dependencies:0.7.1-20240516")
}
