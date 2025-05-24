package com.abrahamcardenes.lpa_domain.useCases.cardBalance

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.date.DateProvider
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllCardsUseCase @Inject constructor(
    private val repository: TravellersRepository,
    private val dateProvider: DateProvider
) {

    val coroutineScope = CoroutineScope(Dispatchers.IO)
    operator fun invoke(): Flow<List<Result<WawaCardBalance, DataError>>> {

        return repository.getAllCardsFromDb().map { cards ->
            cards.map { card ->
                if (!shouldFetchThisCard(
                        card = card,
                        currentTimestamp = dateProvider.getCurrentTimestamp()
                    )
                ) {
                    return@map Result.Success(card)
                }

                // TODO: filter and launch a coroutine for each card :D
                // The thing is, I have to get first the cards list to fetch and then do the multi coroutine call.
                // with async and then add cards that did not need to be fetch
                repository.getBalance(card.code)
            }
        }
    }

    private fun shouldFetchThisCard(card: WawaCardBalance, currentTimestamp: Long): Boolean =
        currentTimestamp > card.lastLocalUpdate + 2.minutes.inWholeMilliseconds
}
