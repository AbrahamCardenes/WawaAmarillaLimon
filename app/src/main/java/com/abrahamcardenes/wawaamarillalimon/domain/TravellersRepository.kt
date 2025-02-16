package com.abrahamcardenes.wawaamarillalimon.domain

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.LineRootDto

interface TravellersRepository {
    suspend fun getBuses(): Result<LineRootDto, DataError>
}
