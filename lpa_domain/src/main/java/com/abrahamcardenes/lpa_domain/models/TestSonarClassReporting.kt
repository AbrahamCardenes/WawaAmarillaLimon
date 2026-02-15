package com.abrahamcardenes.lpa_domain.models

data class TestSonarClassReporting(
    val value1: Int,
    val value2: Int
) {
    fun add(): Int = value1 + value2
    fun sub(): Int = value1 - value2
}
