package com.abrahamcardenes.core_android.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

class CrashlyticsServiceImplTest {

    private val firebaseCrashlyticsMock = mockk<FirebaseCrashlytics>()
    private val crashlyticsServiceImpl = CrashlyticsServiceImpl(firebaseCrashlytics = firebaseCrashlyticsMock)

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a throwable it should be logged into crashlytics`() = runTest {
        coEvery {
            firebaseCrashlyticsMock.recordException(any())
        } answers {}

        crashlyticsServiceImpl.logException(Throwable("Test exception"))
        coVerify {
            firebaseCrashlyticsMock.recordException(any())
        }
    }

    @Test
    fun `Given an exception it should be logged into crashlytics`() = runTest {
        coEvery {
            firebaseCrashlyticsMock.recordException(any())
        } answers {}

        crashlyticsServiceImpl.logException(Exception("Test exception"))
        coVerify {
            firebaseCrashlyticsMock.recordException(any())
        }
    }
}
