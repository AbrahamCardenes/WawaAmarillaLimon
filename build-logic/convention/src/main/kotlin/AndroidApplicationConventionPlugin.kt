import com.abrahamcardenes.wawaamarillalimon.convention.configureCommonGradle
import com.abrahamcardenes.wawaamarillalimon.convention.utils.libs
import com.android.build.api.dsl.ApplicationExtension
import java.util.Properties
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val localProperties =
            Properties().apply {
                val localPropertiesFile = target.rootProject.file("local.properties")
                if (localPropertiesFile.exists()) {
                    load(localPropertiesFile.inputStream())
                }
            }
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

                testOptions {
                    unitTests.all {
                        it.useJUnitPlatform()
                    }
                }

                signingConfigs {
                    create("release") {
                        storeFile = file("wawa-amarilla-key.jks")
                        storePassword = System.getenv("KEY_PASS") ?: localProperties.getProperty("KEY_PASS")
                        keyAlias = System.getenv("KEY_ALIAS") ?: localProperties.getProperty("KEY_ALIAS")
                        keyPassword = System.getenv("KEY_PASS") ?: localProperties.getProperty("KEY_PASS")
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
                        manifestPlaceholders["firebasePerfLog"] = "false"

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
                        manifestPlaceholders["firebasePerfLog"] = "true"
                    }
                }

                configureCommonGradle(this)
            }
        }
    }
}
