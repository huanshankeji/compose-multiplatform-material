import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("common-conventions")
    id("com.huanshankeji.kotlin-multiplatform-conventional-targets")
    id("com.android.library")
}

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    // move to `common-conventions` if necessary

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate {
        common {
            group("androidxCommon") {
                withJvm()
                withAndroidTarget()
                group("ios")
                withWasmJs()
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

android {
    namespace = group as String

    compileSdk = androidSdkVersion
}
