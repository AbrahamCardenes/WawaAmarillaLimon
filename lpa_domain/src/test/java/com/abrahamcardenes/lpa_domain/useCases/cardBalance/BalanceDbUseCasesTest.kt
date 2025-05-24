package com.abrahamcardenes.lpa_domain.useCases.cardBalance

import app.cash.turbine.test
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.date.DateProvider
import com.abrahamcardenes.lpa_domain.fakes.mockedWawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class BalanceDbUseCasesTest {

    private val repository = mockk<TravellersRepository>()
    private val dateProvider = mockk<DateProvider>()
    private lateinit var balanceDbUseCases: BalanceDbUseCases

    @Before
    fun setup() {
        balanceDbUseCases = BalanceDbUseCases(
            saveCard = SaveBalanceUseCase(repository),
            getAllCards = GetAllCardsUseCase(
                repository = repository,
                dateProvider = dateProvider
            ),
            deleteCard = DeleteBalanceUseCase(repository)
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `GIVEN a card that WHERE his lastUpdateTime was less than 2 minutes from the given time it SHOULD NOT request an update AND return the balance card`() = runTest {
        coEvery {
            dateProvider.getCurrentTimestamp()
        } returns 1748000239979L

        coEvery {
            repository.getAllCardsFromDb()
        } returns flow {
            emit(
                listOf(
                    mockedWawaCardBalance()
                )
            )
        }
        balanceDbUseCases.getAllCards().test {
            val itemProduced = awaitItem()
            assertThat(itemProduced).isEqualTo(listOf(Result.Success(mockedWawaCardBalance())))
            awaitComplete()
        }

        coVerifySequence {
            repository.getAllCardsFromDb()
        }
    }

    @Test
    fun `GIVEN a card that WHERE his lastUpdateTime was more than 2 minutes from the given time it SHOULD request an update`() = runTest {
        val expected = listOf(
            Result.Success(mockedWawaCardBalance().copy(lastLocalUpdate = 1748000359979L))
        )
        coEvery {
            dateProvider.getCurrentTimestamp()
        } returns 1748000339979L

        coEvery {
            repository.getAllCardsFromDb()
        } returns flow {
            emit(
                listOf(
                    mockedWawaCardBalance()
                )
            )
        }

        coEvery {
            repository.getBalance(mockedWawaCardBalance().code)
        } returns Result.Success(
            mockedWawaCardBalance()
                .copy(lastLocalUpdate = 1748000359979L)
        )

        balanceDbUseCases.getAllCards().test {
            val itemProduced = awaitItem()
            assertThat(itemProduced).isEqualTo(expected)
            awaitComplete()
        }

        coVerifySequence {
            repository.getAllCardsFromDb()
            repository.getBalance(mockedWawaCardBalance().code)
        }
    }

    @Test
    fun `GIVEN TWO cards that WHERE one has his lastUpdate in less than 2 mins and the other was more than 2 mins it SHOULD request an update and return the updated version and the old one`() =
        runTest {
            val recentCardExpected = mockedWawaCardBalance().copy(
                code = "23456",
                lastLocalUpdate = 1748000299979L
            )
            val oldCardExpected = mockedWawaCardBalance().copy(lastLocalUpdate = 1748000359979L)
            val listExpected = listOf(
                Result.Success(recentCardExpected),
                Result.Success(oldCardExpected)
            )

            coEvery {
                dateProvider.getCurrentTimestamp()
            } returns 1748000339979L

            coEvery {
                repository.getAllCardsFromDb()
            } returns flow {
                emit(
                    listOf(
                        recentCardExpected,
                        mockedWawaCardBalance()
                    )
                )
            }

            coEvery {
                repository.getBalance(oldCardExpected.code)
            } returns Result.Success(oldCardExpected)

            balanceDbUseCases.getAllCards().test {
                val itemProduced = awaitItem()
                assertThat(itemProduced).isEqualTo(listExpected)
                awaitComplete()
            }

            coVerifySequence {
                repository.getAllCardsFromDb()
                repository.getBalance(oldCardExpected.code)
            }

            coVerify(exactly = 0) {
                repository.getBalance(recentCardExpected.code)
            }
        }
}
