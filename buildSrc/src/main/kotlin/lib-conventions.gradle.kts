plugins {
    id("common-conventions")
    // TODO: `id("com.android.library") version "7.2.2"`?
    id("com.huanshankeji.kotlin-multiplatform-jvm-and-js-browser-conventions")
    id("com.huanshankeji.kotlin-multiplatform-sonatype-ossrh-publish-conventions")
}

group = "com.huanshankeji"
version = "0.1.3-SNAPSHOT"

kotlin {
    // move to `common-conventions` if necessary
    sourceSets {
        val androidxCommonMain by creating { dependsOn(commonMain.get()) }
        jvmMain { dependsOn(androidxCommonMain) }
        named("wasmJsMain") { dependsOn(androidxCommonMain) }
    }
}