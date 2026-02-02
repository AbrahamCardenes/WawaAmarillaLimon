package com.abrahamcardenes.wawaamarillalimon.convention.utils

import org.gradle.api.Project

fun Project.pathToPackageName(): String {
    val relativePackageName = path
        .replace(oldChar = ':', newChar = '.').lowercase()

    return "com.abrahamcardenes$relativePackageName"
}
