package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.LineRootDto
import com.abrahamcardenes.wawaamarillalimon.domain.TravellersRepository
import javax.inject.Inject

class GetBusesUseCase @Inject constructor(
    private val repository: TravellersRepository
) {
    suspend operator fun invoke(): Result<LineRootDto, DataError> = repository.getBuses()
}
