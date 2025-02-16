package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.core.safecall
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.LineRootDto
import com.abrahamcardenes.wawaamarillalimon.domain.TravellersRepository

class TravellersRepositoryImpl
(private val api: ApiTravellers) : TravellersRepository {
    override suspend fun getBuses(): Result<LineRootDto, DataError> = safecall {
        api.getBuses()
    }
}
