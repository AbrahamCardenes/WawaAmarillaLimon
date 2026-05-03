plugins {
    alias(libs.plugins.android.test)
    alias(libs.plugins.androidx.baselineprofile)
}

android {
    namespace = "com.abrahamcardenes.macrobenchmark"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
    targetProjectPath = ":app"
    defaultConfig {
        minSdk = 24
        targetSdk = 36
        testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "EMULATOR"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        // This benchmark buildType is used for benchmarking, and should function like your
        // release build (for example, with minification on). It"s signed with a debug key
        // for easy local/CI testing.
        create("benchmark") {
            isDebuggable = false
            signingConfig = getByName("debug").signingConfig
            matchingFallbacks += listOf("release")
        }
    }

    targetProjectPath = ":app"
    experimentalProperties["android.experimental.self-instrumenting"] = true

    testOptions {
        managedDevices {
            localDevices {
                create("pixel6Api36") {
                    device = "Pixel 6 Pro"
                    apiLevel = 36
                    systemImageSource = "aosp"
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.junit)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.uiautomator)
    implementation(libs.androidx.benchmark.macro.junit4)
    androidTestUtil(libs.androidx.test.services)
}

androidComponents {
    beforeVariants(selector().all()) {
        it.enable = it.buildType == "benchmark"
    }
}
