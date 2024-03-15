plugins {
    `kotlin-dsl`
}

repositories {
    //mavenLocal()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.9.23"))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.6.1")
    implementation("com.huanshankeji.team:gradle-plugins:0.5.1")
}
