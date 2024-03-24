import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("common-conventions")
    // TODO: `id("com.android.library") version "7.2.2"`?
    id("com.huanshankeji.kotlin-multiplatform-jvm-and-js-browser-conventions")
    id("com.huanshankeji.kotlin-multiplatform-sonatype-ossrh-publish-conventions")
    //id("com.android.library") // not used yet, the `jvm` target seems to be enough
}

kotlin {
    // move to `common-conventions` if necessary

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate {
        common {
            group("androidxCommon") {
                withJvm()
                group("ios")
                withWasm()
            }
        }
    }

    /*
    sourceSets {
        val androidxCommonMain by creating { dependsOn(commonMain.get()) }
        jvmMain { dependsOn(androidxCommonMain) }
        iosMain { dependsOn(androidxCommonMain) }
        named("wasmJsMain") { dependsOn(androidxCommonMain) }
    }
    */
}