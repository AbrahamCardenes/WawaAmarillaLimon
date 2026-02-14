// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt.android.plugin) apply false
    alias(libs.plugins.ksp) version "2.3.4"
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
    id("org.sonarqube") version "6.3.1.5724"
    id("jacoco")
}

buildscript {
    dependencies {
        classpath(libs.org.jacoco.core)
    }
    repositories {
        google()
    }
}

apply(from = "$rootDir/sonar.gradle")

subprojects {
    apply(from = "$rootDir/jacoco.gradle")
    // PmaxForks will set to that cpu forks -> ./gradlew testDebugUnitTest -PmaxForks=4
    tasks.withType<Test>().configureEach {
        maxParallelForks = (
            findProperty("maxForks")?.toString()?.toInt()
                ?: (Runtime.getRuntime().availableProcessors() / 2)
            )
            .coerceAtLeast(1)
    }
}

tasks.register<Copy>("addPreCommitGitHookOnBuild") {
    group = "git"
    description = "Copies pre-commit hook into .git/hooks"

    from(layout.projectDirectory.file(".scripts/pre-commit"))
    into(layout.projectDirectory.dir(".git/hooks"))
    rename { "pre-commit" }
}
