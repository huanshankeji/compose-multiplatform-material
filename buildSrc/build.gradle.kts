plugins {
    `kotlin-dsl`
}

repositories {
    //mavenLocal()
    gradlePluginPortal()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.9.23"))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.6.2")
    implementation("com.huanshankeji.team:gradle-plugins:0.5.1")
    implementation("com.android.tools.build:gradle:8.2.2")
    implementation("com.huanshankeji:common-gradle-dependencies:0.7.1-20240516")
}
