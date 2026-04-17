import com.android.build.api.dsl.LibraryExtension
import java.util.Properties

plugins {
    alias(libs.plugins.convention.common.android)
    alias(libs.plugins.convention.jacoco)
    alias(libs.plugins.kotlin.serialization)
}

val localProperties =
    Properties().apply {
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

fun getApiParadas(): String {
    val apiFromEnv = System.getenv("API_WAWAS")
    return apiFromEnv ?: (localProperties.getProperty("API_PARADAS") ?: "")
}

fun getApiTravellers(): String {
    val apiFromEnv = System.getenv("API_TRAVELLERS")
    return apiFromEnv ?: (localProperties.getProperty("API_TRAVELLERS") ?: "")
}

fun getApiStaticApp(): String {
    val apiFromEnv = System.getenv("API_STATICAPP")
    return apiFromEnv ?: (localProperties.getProperty("API_STATICAPP") ?: "")
}

configure<LibraryExtension> {
    buildTypes {
        release {
            manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon"
            buildConfigField("String", "API_PARADAS", "\"${getApiParadas()}\"")
            buildConfigField("String", "API_TRAVELLERS", "\"${getApiTravellers()}\"")
            buildConfigField("String", "API_STATICAPP", "\"${getApiStaticApp()}\"")
        }

        debug {
            manifestPlaceholders["appLabel"] = "Wawa Amarilla Limon Dev"
            buildConfigField("String", "API_PARADAS", "\"${getApiParadas()}\"")
            buildConfigField("String", "API_TRAVELLERS", "\"${getApiTravellers()}\"")
            buildConfigField("String", "API_STATICAPP", "\"${getApiStaticApp()}\"")
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
    // Retrofit and converters
    implementation(libs.retrofit)
    implementation(libs.converter.kotlinx)
    implementation(libs.kotlinx.serialization.json)
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
