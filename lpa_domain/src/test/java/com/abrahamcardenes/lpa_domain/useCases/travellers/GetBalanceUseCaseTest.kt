package com.abrahamcardenes.lpa_domain.useCases.travellers

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.fakes.mockedWawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetBalanceUseCaseTest {
    private val repository = mockk<TravellersRepository>()
    private lateinit var getBalanceUseCase: GetBalanceUseCase

    @Before
    fun setup() {
        getBalanceUseCase = GetBalanceUseCase(
            repository = repository
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a wawa card number it should return a WawaCardBalance object`() = runTest {
        val expected = Result.Success(mockedWawaCardBalance())
        coEvery {
            repository.getBalance(cardNumber = mockedWawaCardBalance().code)
        } returns Result.Success(mockedWawaCardBalance())

        val result = getBalanceUseCase(mockedWawaCardBalance().code)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Given a wawa card number it should Return data error if the call fails`() = runTest {
        val expected = Result.Error(DataError.Remote.RequestTimeout)
        coEvery {
            repository.getBalance(cardNumber = mockedWawaCardBalance().code)
        } returns Result.Error(DataError.Remote.RequestTimeout)

        val result = getBalanceUseCase(mockedWawaCardBalance().code)
        assertThat(result).isEqualTo(expected)
    }
}
