import java.util.Properties
import kotlin.apply

plugins {
    alias(libs.plugins.convention.common.android)
    alias(libs.plugins.convention.jacoco)
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
    buildTypes {
        release {
            manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon"
            buildConfigField("String", "API_PARADAS", "\"${System.getenv("API_WAWAS")}\"")
            buildConfigField("String", "API_TRAVELLERS", "\"${System.getenv("API_TRAVELLERS")}\"")
            buildConfigField("String", "API_STATICAPP", "\"${System.getenv("API_STATICAPP")}\"")
        }

        debug {
            manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon Dev"
            buildConfigField("String", "API_PARADAS", "\"$apiParadas\"")
            buildConfigField("String", "API_TRAVELLERS", "\"$apiTravellers\"")
            buildConfigField("String", "API_STATICAPP", "\"$apiStaticApp\"")
        }
    }
}

dependencies {
    // Modules
    implementation(project(Modules.LPA_DOMAIN))
    implementation(project(Modules.CORE_DB))
    implementation(project(Modules.CORE))
    implementation(project(Modules.CORE_ANDROID))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
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
    kspTest(libs.hilt.compiler)

    testImplementation(project(Modules.CORE))
    testImplementation(libs.junit)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.bundles.testing)
    testImplementation(libs.turbine)

    androidTestImplementation(libs.bundles.testing)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.compiler)
}
