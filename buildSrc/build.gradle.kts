plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal() // TODO comment out when not needed so the build is always reproducible by others
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    val kotlinVersion = "2.1.0"
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.7.1")
    implementation("com.huanshankeji.team:gradle-plugins:0.9.0") // don't use a snapshot version in a main branch
    implementation("com.android.tools.build:gradle:8.5.2")
    implementation("com.huanshankeji:common-gradle-dependencies:0.9.0-20241203") // don't use a snapshot version in a main branch
}
