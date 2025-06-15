package com.abrahamcardenes.lpa_domain.useCases.cardBalance

import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import javax.inject.Inject

class SaveBalanceUseCase @Inject constructor(private val repository: TravellersRepository) {
    suspend operator fun invoke(wawaCard: WawaCardBalance) {
        repository.saveCard(wawaCard = wawaCard)
    }
}
