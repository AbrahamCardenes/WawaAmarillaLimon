import com.abrahamcardenes.wawaamarillalimon.convention.configureCommonGradle
import com.abrahamcardenes.wawaamarillalimon.convention.libs
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("🔥 Applying AndroidApplicationConventionPlugin to ${target.path}")

        with(target) {
            with(pluginManager) {
                apply("com.android.application")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    namespace = "com.abrahamcardenes.wawaamarillalimon"
                    applicationId = libs.findVersion("projectApplicationId").get().toString()
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
                    versionName = libs.findVersion("projectVersionName").get().toString()
                }

                signingConfigs {
                    create("release") {
                        storeFile = file("wawa-amarilla-key.jks")
                        storePassword = System.getenv("KEY_PASS") ?: ""
                        keyAlias = System.getenv("KEY_ALIAS") ?: ""
                        keyPassword = System.getenv("KEY_PASS") ?: ""
                    }
                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon"
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )

                        signingConfig = signingConfigs.getByName("release")

                        ndk {
                            debugSymbolLevel = "FULL"
                        }
                    }

                    debug {
                        isMinifyEnabled = false
                        isDebuggable = true
                        manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon Dev"
                        applicationIdSuffix = ".dev"
                        enableUnitTestCoverage = true
                    }
                }

                configureCommonGradle(this)
            }
        }
    }
}
