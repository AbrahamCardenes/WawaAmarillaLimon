package com.abrahamcardenes.lpa_domain.models.demoJacocoConventionPlugin

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DemoJacocoOneTest {
    @Test
    fun `Given When Then`() {
        val demo1 = DemoJacocoOne(
            numberOne = 1,
            numberTwo = 2
        )

        assertThat(demo1.sum()).isEqualTo(3)
    }
}
