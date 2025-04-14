import java.util.Properties
import kotlin.apply

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android.plugin)
    alias(libs.plugins.ksp)
}

val localProperties =
    Properties().apply {
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

val apiParadas: String = localProperties.getProperty("API_PARADAS") ?: ""
val apiTravellers: String = localProperties.getProperty("API_TRAVELLERS") ?: ""
val apiStaticApp: String = localProperties.getProperty("API_STATICAPP") ?: ""

android {
    namespace = "com.abrahamcardenes.lpa_data"
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

        release {
            isMinifyEnabled = false
            manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_PARADAS", "\"${System.getenv("API_WAWAS")}\"")
            buildConfigField("String", "API_TRAVELLERS", "\"${System.getenv("API_TRAVELLERS")}\"")
            buildConfigField("String", "API_STATICAPP", "\"${System.getenv("API_STATICAPP")}\"")
        }

        debug {
            isMinifyEnabled = false
            manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon Dev"
            android.buildFeatures.buildConfig = true
            buildConfigField("String", "API_PARADAS", "\"$apiParadas\"")
            buildConfigField("String", "API_TRAVELLERS", "\"$apiTravellers\"")
            buildConfigField("String", "API_STATICAPP", "\"$apiStaticApp\"")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit and moshi
    implementation(libs.retrofit)
    implementation(libs.moshi)
    implementation(libs.converter.moshi)
    ksp(libs.moshi.kotlin.codegen)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // HILT
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.compiler)
    testImplementation(libs.hilt.android.testing)
    kspTest(libs.hilt.compiler)

    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.testing)
    testImplementation(libs.turbine)

    // Modules
    implementation(project(Modules.LPA_DOMAIN))
    implementation(project(Modules.CORE_DB))
    implementation(project(Modules.CORE))
    testImplementation(project(Modules.CORE))
}
