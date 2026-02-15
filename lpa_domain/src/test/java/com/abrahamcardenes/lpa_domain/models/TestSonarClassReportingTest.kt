package com.abrahamcardenes.lpa_domain.models

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TestSonarClassReportingTest {
    @Test
    fun `Some random test to show coverage`() {
        val testSonarClassReporting = TestSonarClassReporting(value1 = 1, value2 = 2)

        assertThat(testSonarClassReporting.add()).isEqualTo(3)
    }
}
