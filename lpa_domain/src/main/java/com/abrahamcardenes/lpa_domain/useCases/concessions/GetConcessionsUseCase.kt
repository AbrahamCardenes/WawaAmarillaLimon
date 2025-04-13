package com.abrahamcardenes.lpa_domain.useCases.concessions

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.lpa_domain.repositories.BusRoutesRepository
import javax.inject.Inject

class GetConcessionsUseCase @Inject constructor(
    private val busRoutesRepository: BusRoutesRepository
) {
    suspend operator fun invoke(): Result<Concessions, DataError> = busRoutesRepository.getLines()
}
