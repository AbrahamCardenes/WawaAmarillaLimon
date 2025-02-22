package com.abrahamcardenes.wawaamarillalimon.domain

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession

interface TravellersRepository {
    suspend fun getConcessions(): Result<List<Concession>, DataError>
}
