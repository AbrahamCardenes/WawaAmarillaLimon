package com.abrahamcardenes.lpa_domain.useCases.busStops

import app.cash.turbine.test
import com.abrahamcardenes.lpa_domain.fakes.fakeListBusStopDetailOffline
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import io.kotest.matchers.shouldBe
import io.kotest.runner.junit4.FunSpec
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow

class GetBusStopsUseCaseTest : FunSpec({

    lateinit var getBusStopsUseCase: GetBusStopsUseCase

    val busStopRepository = mockk<BusStopsRepository>()

    beforeTest {
        getBusStopsUseCase = GetBusStopsUseCase(
            busStopRepository = busStopRepository
        )
    }

    afterTest {
        clearAllMocks()
    }

    test("Given a two emissions Then it should assert the correct emissions") {
        coEvery {
            busStopRepository.getAllLocalBusStops()
        } returns flow {
            emit(fakeListBusStopDetailOffline())
            emit(fakeListBusStopDetailOffline(setSecondFavoriteValue = false))
        }

        getBusStopsUseCase().test {
            awaitItem() shouldBe fakeListBusStopDetailOffline()
            awaitItem() shouldBe fakeListBusStopDetailOffline(setSecondFavoriteValue = false)

            awaitComplete()
        }
    }
})
