


import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.antlr
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class SpringBootBasePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            dependencies {
                val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

                val antlrVersion = libs.findVersion("antlr").get().toString()
                "runtimeOnly"("org.antlr:antlr4-runtime:${antlrVersion}")

                val lombok = libs.findLibrary("lombok")
                "compileOnly"(lombok)
                "annotationProcessor"(lombok)
            }
        }
    }
}