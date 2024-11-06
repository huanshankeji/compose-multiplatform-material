plugins {
    id("org.jetbrains.dokka")
}

dokka {
    dokkaSourceSets.all {
        sourceLink {
            remoteUrl("https://github.com/huanshankeji/compose-multiplatform-material/tree/v${version}/${project.name}")
            remoteLineSuffix.set("#L")
        }
    }

    // https://github.com/Kotlin/dokka/issues/3885#issuecomment-2449645480
    dokkaGeneratorIsolation = ClassLoaderIsolation()
}
