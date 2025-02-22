package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.core.map
import com.abrahamcardenes.wawaamarillalimon.core.safecall
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.toDomain
import com.abrahamcardenes.wawaamarillalimon.domain.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession

class TravellersRepositoryImpl
(private val api: ApiTravellers) : TravellersRepository {
    override suspend fun getConcessions(): Result<List<Concession>, DataError> = safecall {
        api.getBuses()
    }.map {
        it.response.concessions.lines.toDomain()
    }
}
