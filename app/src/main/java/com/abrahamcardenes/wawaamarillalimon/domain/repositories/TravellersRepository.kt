package com.abrahamcardenes.wawaamarillalimon.domain.repositories

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.WawaCardNumber

interface TravellersRepository {
    suspend fun getConcessions(): Result<List<Concession>, DataError>
    suspend fun getTimetables(busNumber: BusIdNumber): Result<BusTimetables, DataError>
    suspend fun getBalance(cardNumber: WawaCardNumber): Result<WawaCardBalance, DataError>
}
