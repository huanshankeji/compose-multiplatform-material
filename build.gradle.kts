tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

plugins {
    id("org.jetbrains.dokka")
}

dependencies {
    subprojects.filter { it.name.startsWith(project.name) }.forEach {
        dokka(it)
    }
}
