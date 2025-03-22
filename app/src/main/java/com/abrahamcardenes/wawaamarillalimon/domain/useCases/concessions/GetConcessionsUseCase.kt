package com.abrahamcardenes.wawaamarillalimon.domain.useCases.concessions

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository
import javax.inject.Inject

class GetConcessionsUseCase @Inject constructor(
    private val busRoutesRepository: BusRoutesRepository
) {
    suspend operator fun invoke(): Result<Concessions, DataError> = busRoutesRepository.getLines()
}
