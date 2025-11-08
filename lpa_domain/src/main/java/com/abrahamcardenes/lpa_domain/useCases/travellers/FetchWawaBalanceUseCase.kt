package com.abrahamcardenes.lpa_domain.useCases.travellers

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

class FetchWawaBalanceUseCase @Inject constructor(
    private val repository: TravellersRepository,
    private val crashlyticsService: CrashlyticsService
) {
    suspend operator fun invoke(wawaCards: List<WawaCardBalance>, saturationThreshold: Int = 10): List<WawaCardBalance> {
        val semaphore = Semaphore(permits = saturationThreshold)
        val updatedCards = supervisorScope {
            wawaCards.map {
                async {
                    semaphore.withPermit {
                        repository.getBalance(cardNumber = it.code)
                    }
                }
            }
        }.awaitAll()

        val cardsThatICanShow = mutableListOf<WawaCardBalance>()
        val successfulCards = updatedCards.filter { cardResult ->
            cardResult is Result.Success
        }

        val errorCards = updatedCards.filter { cardResult ->
            cardResult is Result.Error
        }

        successfulCards.forEach { cardResult ->
            cardResult.onSuccess { card -> cardsThatICanShow.add(card) }
        }

        errorCards.forEach { errorCard ->
            errorCard.onError { error ->
                logErrorIfIsUnknown(error)
            }
        }

        val newCards = cardsThatICanShow.map { it.code }.toSet()
        val oldCardsThatCouldNotBeUpdated = wawaCards.filter { it.code !in newCards }

        return cardsThatICanShow + oldCardsThatCouldNotBeUpdated
    }

    private suspend fun logErrorIfIsUnknown(it: DataError) {
        if (it is DataError.Remote.UnknownError) {
            crashlyticsService.logException(it.error ?: Exception("Null exception in Data Error Unknown"))
        }
    }
}
