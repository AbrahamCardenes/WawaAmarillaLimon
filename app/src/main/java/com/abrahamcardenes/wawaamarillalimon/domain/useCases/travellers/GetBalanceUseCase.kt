package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.WawaCardNumber
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(private val repository: TravellersRepository) {
    suspend operator fun invoke(wawaCardNumber: WawaCardNumber): Result<WawaCardBalance, DataError> =
        repository.getBalance(cardNumber = wawaCardNumber)
}
