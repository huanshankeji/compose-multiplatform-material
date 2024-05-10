import org.jetbrains.compose.ComposeBuildConfig

val projectVersion = "0.3.0"

object DependencyVersions {
    const val composeMultiplatform = ComposeBuildConfig.composeVersion // for "ui-unit"
    val kobweb = "0.17.3"
    val huanshankejiComposeHtml = "0.3.0"
    val kmdc = "0.1.2"
    val materialSymbols = "0.17.4"

    object Androidx {
        val activityCompose = "1.9.0"
        val compose = "1.6.6"
    }
}
