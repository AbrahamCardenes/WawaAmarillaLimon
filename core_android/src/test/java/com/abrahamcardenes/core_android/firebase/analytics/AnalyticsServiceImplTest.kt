package com.abrahamcardenes.core_android.firebase.analytics

import android.os.Bundle
import com.google.common.truth.Truth.assertThat
import com.google.firebase.analytics.FirebaseAnalytics
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.mockkConstructor
import java.math.BigInteger
import org.junit.After
import org.junit.Before
import org.junit.Test

class AnalyticsServiceImplTest {

    private val firebaseMock = mockk<FirebaseAnalytics>()

    private val analyticsServiceImpl = AnalyticsServiceImpl(
        firebaseAnalytics = firebaseMock
    )

    @Before
    fun setup() {
        mockkConstructor(Bundle::class)
        every { anyConstructed<Bundle>().putString(any(), any()) } just Runs
        every { anyConstructed<Bundle>().putInt(any(), any()) } just Runs
        every { anyConstructed<Bundle>().putLong(any(), any()) } just Runs
        every { anyConstructed<Bundle>().putFloat(any(), any()) } just Runs
        every { anyConstructed<Bundle>().putDouble(any(), any()) } just Runs
        every { anyConstructed<Bundle>().putBoolean(any(), any()) } just Runs
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a event and params When sendLogEvent is called Then firebase logEvent is called`() {
        coEvery {
            firebaseMock.logEvent("concession_look_up", any())
        } returns Unit

        analyticsServiceImpl.sendLogEvent(
            event = AnalyticsEvents.CONCESSION_LOOK_UP,
            params = arrayOf(
                Pair(AnalyticsParams.CONCESSION_ID, "concessionId"),
                Pair(AnalyticsParams.STOP_NUMBER, 1),
                Pair(AnalyticsParams.STOP_NUMBER, 1L),
                Pair(AnalyticsParams.STOP_NUMBER, 1f),
                Pair(AnalyticsParams.STOP_NUMBER, 1.0),
                Pair(AnalyticsParams.STOP_NAME, false)
            )
        )

        coVerify {
            firebaseMock.logEvent(AnalyticsEvents.CONCESSION_LOOK_UP.value, any())
        }
    }

    @Test
    fun `Given a event with an unknown type Then it should throw an exception`() {
        coEvery {
            firebaseMock.logEvent("concession_look_up", any())
        } returns Unit

        try {
            analyticsServiceImpl.sendLogEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                params = arrayOf(
                    Pair(AnalyticsParams.CONCESSION_ID, BigInteger.ONE)
                )
            )
        } catch (e: Exception) {
            assertThat(e).isInstanceOf(IllegalArgumentException::class.java)
            assertThat(e.message).isEqualTo("Unsupported type for Firebase Analytics parameter, value: 1")
        }
    }
}
