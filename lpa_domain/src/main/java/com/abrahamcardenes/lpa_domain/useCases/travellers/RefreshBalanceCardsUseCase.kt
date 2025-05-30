package com.abrahamcardenes.lpa_domain.useCases.travellers

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import javax.inject.Inject

class RefreshBalanceCardsUseCase @Inject constructor(private val repository: TravellersRepository) {
    suspend operator fun invoke(wawaCards: List<WawaCardBalance>): List<WawaCardBalance> {
        val semaphore = Semaphore(10)
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
                println(error.toString())
                // logErrorIfIsUnknown(error)
            }
        }


        val newCards = cardsThatICanShow.map { it.code }.toSet()
        val oldCardsThatCouldNotBeUpdated = wawaCards.filter { it.code !in newCards }

        println(newCards)

        println(oldCardsThatCouldNotBeUpdated.map { it.code })

        return cardsThatICanShow + oldCardsThatCouldNotBeUpdated
    }
}