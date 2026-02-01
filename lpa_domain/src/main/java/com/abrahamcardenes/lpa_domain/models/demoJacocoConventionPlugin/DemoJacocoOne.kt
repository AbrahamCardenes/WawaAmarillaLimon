package com.abrahamcardenes.lpa_domain.models.demoJacocoConventionPlugin

data class DemoJacocoOne(
    val numberOne: Int,
    val numberTwo: Int
) {

    fun sum(): Int = numberOne + numberTwo

    fun sub(): Int = numberOne - numberTwo

    fun mul(): Int = numberOne * numberTwo
}
