// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt.android.plugin) apply false
    alias(libs.plugins.ksp) version "2.1.0-1.0.29"
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
}

task("addPreCommitGitHookOnBuild") {
    exec {
        commandLine("cp", "./.scripts/pre-commit", "./.git/hooks")
    }
    println("✅ Added Pre Commit")
}
