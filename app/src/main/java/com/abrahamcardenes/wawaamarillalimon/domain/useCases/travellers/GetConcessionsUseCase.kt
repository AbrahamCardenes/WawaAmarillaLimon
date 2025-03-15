package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.TravellersRepository
import javax.inject.Inject

class GetConcessionsUseCase @Inject constructor(
    private val repository: TravellersRepository
) {
    suspend operator fun invoke(): Result<List<Concession>, DataError> = repository.getConcessions()
}
