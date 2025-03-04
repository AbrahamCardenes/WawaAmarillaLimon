package com.abrahamcardenes.wawaamarillalimon.domain

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber

interface TravellersRepository {
    suspend fun getConcessions(): Result<List<Concession>, DataError>

    suspend fun getTimetables(busNumber: BusIdNumber): Result<BusTimetables, DataError>
}
