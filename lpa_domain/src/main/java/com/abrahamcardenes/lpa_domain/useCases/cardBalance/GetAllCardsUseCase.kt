package com.abrahamcardenes.lpa_domain.useCases.cardBalance

import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetAllCardsUseCase @Inject constructor(
    private val repository: TravellersRepository
) {

    operator fun invoke(): Flow<List<WawaCardBalance>> {
        return repository.getAllCardsFromDb()
    }

}
