package com.abrahamcardenes.lpa_domain.useCases.travellers

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.abrahamcardenes.lpa_domain.valueObjects.WawaCardNumber
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(private val repository: TravellersRepository) {
    suspend operator fun invoke(wawaCardNumber: WawaCardNumber): Result<WawaCardBalance, DataError> =
        repository.getBalance(cardNumber = wawaCardNumber)
}
