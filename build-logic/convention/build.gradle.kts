import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.abrahamcardenes.wawaamarillalimon.convention.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.abrahamcardenes.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("commonGradleConvention") {
            id = "com.abrahamcardenes.convention.android.common"
            implementationClass = "CommonGradleConventionPlugin"
        }

        register("jacocoConventionPlugin") {
            id = "com.abrahamcardenes.convention.jacoco"
            implementationClass = "JacocoConventionPlugin"
        }
    }
}
