package com.abrahamcardenes.lpa_domain.repositories

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.travellers.BusTimetables
import com.abrahamcardenes.lpa_domain.models.travellers.Concession
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.valueObjects.BusIdNumber
import com.abrahamcardenes.lpa_domain.valueObjects.WawaCardNumber

interface TravellersRepository {
    @Deprecated("Use BusRoutesRepository instead")
    suspend fun getConcessions(): Result<List<Concession>, DataError>

    @Deprecated("Use BusRoutesRepository instead")
    suspend fun getTimetables(busNumber: BusIdNumber): Result<BusTimetables, DataError>
    suspend fun getBalance(cardNumber: WawaCardNumber): Result<WawaCardBalance, DataError>
}
