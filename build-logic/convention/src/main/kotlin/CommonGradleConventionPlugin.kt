import com.abrahamcardenes.wawaamarillalimon.convention.libs
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonGradleConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("🔥 Applying CommonGradleConventionPlugin to ${project.path}")

        with(project) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.dagger.hilt.android")
                apply("com.google.devtools.ksp")
                apply("jacoco")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    // namespace = "com.abrahamcardenes.lpa_domain" TODO
                    compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()
                    minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

                // There are so much in common with AndroidApplicationConventionPlugin
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }

                tasks.withType<KotlinCompile>().configureEach {
                    compilerOptions {
                        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
                    }
                }

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                        merges += "META-INF/LICENSE.md"
                        merges += "META-INF/LICENSE-notice.md"
                    }
                }

                ndkVersion = "28.0.12674087 rc2"
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
