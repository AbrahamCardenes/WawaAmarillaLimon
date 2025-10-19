plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android.plugin)
    alias(libs.plugins.ksp)
    id("jacoco")
}

android {
    namespace = "com.abrahamcardenes.lpa_domain"
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            enableUnitTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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

dependencies {
    // Modules
    implementation(project(Modules.CORE))
    implementation(project(Modules.CORE_ANDROID))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    // HILT
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    kspTest(libs.hilt.compiler)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.bundles.testing)
    testImplementation(libs.turbine)
    testImplementation(project(Modules.CORE))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.bundles.testing)
    kspAndroidTest(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.testing)
}

jacoco {
    toolVersion = "0.8.14"
}

val fileFilter = listOf(
    "**/R.class",
    "**/R$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*",
    "android/**/*.*"
)

tasks.withType<Test>().configureEach {
    jacoco {
        setExcludes(listOf("jdk.internal.*"))
    }
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest")
    group = "ReportingSonar"
    description = "Generate Jacoco coverage reports after running tests."

    val debugTree = fileTree(
        mapOf(
            "dir" to "$buildDir/intermediates/classes/debug",
            "excludes" to fileFilter // assuming fileFilter is defined elsewhere as a List<String>
        )
    )

    val mainSrc = "$projectDir/src/main/java"

    sourceDirectories.setFrom(files(mainSrc))
    classDirectories.setFrom(files(debugTree))

    executionData.setFrom(
        fileTree(
            mapOf(
                "dir" to buildDir,
                "includes" to listOf(
                    "jacoco/testDebugUnitTest.exec",
                    "outputs/code-coverage/connected/*coverage.ec"
                )
            )
        )
    )

    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}
