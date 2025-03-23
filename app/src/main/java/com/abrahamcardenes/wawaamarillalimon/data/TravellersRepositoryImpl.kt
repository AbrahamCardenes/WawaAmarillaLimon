package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.core.map
import com.abrahamcardenes.wawaamarillalimon.core.safecall
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.toDomain
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.WawaCardNumber

class TravellersRepositoryImpl(private val api: ApiTravellers) : TravellersRepository {
    override suspend fun getConcessions(): Result<List<Concession>, DataError> = safecall {
        api.getBuses()
    }.map {
        it.response.concessions.lines.toDomain()
    }

    override suspend fun getTimetables(busNumber: BusIdNumber): Result<BusTimetables, DataError> = safecall {
        api.getTimetable(busIdNumber = busNumber)
    }.map {
        it.toDomain()
    }

    override suspend fun getBalance(cardNumber: WawaCardNumber): Result<WawaCardBalance, DataError> = safecall {
        api.getBalance(cardNumber = cardNumber)
    }.map {
        it.toDomain()
    }
}
