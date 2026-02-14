import com.abrahamcardenes.wawaamarillalimon.convention.configureCommonGradle2
import com.abrahamcardenes.wawaamarillalimon.convention.utils.pathToPackageName
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType

class CommonGradleConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.library")
                apply("com.google.dagger.hilt.android")
                apply("com.google.devtools.ksp")
                apply("jacoco")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    namespace = project.pathToPackageName()
                }

                buildFeatures.buildConfig = true

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }

                    debug {
                        isMinifyEnabled = false
                        enableUnitTestCoverage = true
                    }
                }
                configureCommonGradle2(this)
            }

            afterEvaluate {
                val libraryExtension = extensions.findByType<LibraryExtension>()
                libraryExtension?.let {
                    it.defaultConfig {
                        consumerProguardFiles("consumer-rules.pro")
                    }
                } ?: run {
                    println("Consumer guard applied in unknown android component ")
                    return@afterEvaluate
                }
            }
        }
    }
}
