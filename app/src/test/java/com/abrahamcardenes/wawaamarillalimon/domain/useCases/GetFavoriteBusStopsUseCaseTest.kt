package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetFavoriteBusStopsUseCaseTest {
    private val repository = mockk<BusStopsRepository>(relaxed = true)
    private lateinit var getFavoriteBusStopsUseCase: GetFavoriteBusStopsUseCase

    @Before
    fun setup() {
        getFavoriteBusStopsUseCase = GetFavoriteBusStopsUseCase(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `When invoking getFavoriteBusStopsUseCase it should return a flow of favorite bus stops`() = runTest {
        val expected = listOf(
            BusStop(
                addressName = "TEATRO, 99",
                stopNumber = 99,
                isSavedInDb = true
            )
        )

        coEvery {
            repository.getAllLocalBusStops()
        } returns flow {
            emit(
                expected
            )
        }
        assertThat(getFavoriteBusStopsUseCase().single()).isEqualTo(expected)
    }

}