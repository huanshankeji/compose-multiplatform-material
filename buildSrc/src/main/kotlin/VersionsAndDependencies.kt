import com.huanshankeji.CommonDependencies
import org.jetbrains.compose.ComposeBuildConfig

val projectVersion = "0.4.0-SNAPSHOT"

val commonDependencies = CommonDependencies()

object DependencyVersions {
    const val composeMultiplatform = ComposeBuildConfig.composeVersion // for "ui-unit"
    val kobweb = "0.18.0"
    val huanshankejiComposeHtml = "0.4.0-SNAPSHOT" // TODO don't use a snapshot version in a main branch
    val kmdc = "0.1.2"
    val materialSymbols = "0.19.0"

    object Androidx {
        val activityCompose = "1.9.0"
        val compose = "1.6.6"
    }
}
