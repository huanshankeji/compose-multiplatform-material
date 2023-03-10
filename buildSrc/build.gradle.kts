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
    implementation(kotlin("gradle-plugin", "1.8.10"))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.3.1")
    implementation("com.huanshankeji.team:gradle-plugins:0.4.0") {
        exclude("org.jetbrains.kotlin")
    }
}
