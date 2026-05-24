package com.abrahamcardenes.core_android.dataStore

import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import io.kotest.matchers.shouldBe
import io.kotest.runner.junit4.BehaviorSpec
import io.mockk.clearAllMocks
import io.mockk.mockk

class WawaSettingsDataStoreTest : BehaviorSpec(
    {

        val crashlytics = mockk<CrashlyticsService>(relaxed = true)
        lateinit var fakeDataStore: FakeDataStore
        lateinit var wawaSettings: WawaSettingsDataStore

        beforeTest {
            fakeDataStore = FakeDataStore()
            wawaSettings = WawaSettingsDataStore(fakeDataStore, crashlytics)
        }

        afterTest {
            clearAllMocks()
        }

        given("saveEtag") {
            then("it stores the etag") {
                wawaSettings.saveEtag("123")
                val result = wawaSettings.getEtag()
                result shouldBe "123"
            }
        }

        given("no etag saved previously") {
            then("it should return null") {
                val result = wawaSettings.getEtag()
                result shouldBe null
            }
        }
    }
)
