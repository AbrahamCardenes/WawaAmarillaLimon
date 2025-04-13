package com.abrahamcardenes.lpa_presentation.utils

import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.Test

class DoubleToLocalCurrencyTest {

    @Test
    fun `Given a double of 2 decimals and english locale it should return a string with 2 decimals separated by dot`() {
        val double = 12.3456
        val result = double.toLocalCurrency(Locale.ENGLISH)
        assertThat(result).isEqualTo("12.35")
    }

    @Test
    fun `Given a double of 2 decimals and italian locale it should return a string with 2 decimals and separated by a comma`() {
        val double = 12.3456
        val result = double.toLocalCurrency(Locale.ITALIAN)
        assertThat(result).isEqualTo("12,35")
    }

    @Test
    fun `Given a double of 1 decimal and italian locale it should return a string with 2 decimals and separated by a comma`() {
        val double = 6.6
        val result = double.toLocalCurrency(Locale.ITALIAN)
        assertThat(result).isEqualTo("6,60")
    }
}
