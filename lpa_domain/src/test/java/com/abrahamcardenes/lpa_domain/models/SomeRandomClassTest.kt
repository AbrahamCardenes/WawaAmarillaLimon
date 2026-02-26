package com.abrahamcardenes.lpa_domain.models

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SomeRandomClassTest {
    @Test
    fun `Some random test to show coverage`() {
        val someRandomClass = SomeRandomClass(value1 = 1, value2 = 2)

        assertThat(someRandomClass.add()).isEqualTo(3)
    }
}
