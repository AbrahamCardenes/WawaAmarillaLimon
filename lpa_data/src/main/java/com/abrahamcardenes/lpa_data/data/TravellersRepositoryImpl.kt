package com.abrahamcardenes.lpa_data.data

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.core.network.safecall
import com.abrahamcardenes.core_android.date.DateProvider
import com.abrahamcardenes.core_db.cards.WawaBalanceDao
import com.abrahamcardenes.lpa_data.data.mappers.wawaBalance.toDomain
import com.abrahamcardenes.lpa_data.data.mappers.wawaBalance.toEntity
import com.abrahamcardenes.lpa_data.remote.apis.ApiTravellers
import com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable.mappers.toDomain
import com.abrahamcardenes.lpa_data.remote.dtos.travellers.toDomain
import com.abrahamcardenes.lpa_domain.models.travellers.BusTimetables
import com.abrahamcardenes.lpa_domain.models.travellers.Concession
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.abrahamcardenes.lpa_domain.valueObjects.BusIdNumber
import com.abrahamcardenes.lpa_domain.valueObjects.WawaCardNumber
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TravellersRepositoryImpl(
    private val api: ApiTravellers,
    private val dateProvider: DateProvider,
    private val wawaBalanceDao: WawaBalanceDao
) : TravellersRepository {
    @Deprecated("Use BusRoutesRepository instead")
    override suspend fun getConcessions(): Result<List<Concession>, DataError> = safecall {
        api.getBuses()
    }.map {
        it.response.concessions.lines.toDomain()
    }

    @Deprecated("Use BusRoutesRepository instead")
    override suspend fun getTimetables(busNumber: BusIdNumber): Result<BusTimetables, DataError> = safecall {
        api.getTimetable(busIdNumber = busNumber)
    }.map {
        it.toDomain()
    }

    override suspend fun getBalance(cardNumber: WawaCardNumber): Result<WawaCardBalance, DataError> = safecall {
        api.getBalance(cardNumber = cardNumber)
    }.map {
        it.toDomain(timestamp = dateProvider.getCurrentTimestamp())
    }

    override suspend fun saveCard(wawaCard: WawaCardBalance) {
        wawaBalanceDao.updateOrInsert(wawaBalance = wawaCard.toEntity())
    }

    override suspend fun deleteCard(wawaCard: WawaCardBalance) {
        wawaBalanceDao.deleteWawaBalanceByCode(code = wawaCard.code)
    }

    override fun getAllCardsFromDb(): Flow<List<WawaCardBalance>> = wawaBalanceDao.getAllWawaBalances().map { entityCard ->
        entityCard.map { it.toDomain() }
    }
}
