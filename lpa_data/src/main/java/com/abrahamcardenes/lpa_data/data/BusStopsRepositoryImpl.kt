package com.abrahamcardenes.lpa_data.data

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.core.network.safecall
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.lpa_data.data.mappers.toDomain
import com.abrahamcardenes.lpa_data.data.mappers.toEntity
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class BusStopsRepositoryImpl(
    private val api: ApiParadas,
    private val busStopDao: BusStopDao
) : BusStopsRepository {

    override suspend fun getBusStops(): Result<List<BusStop>, DataError> = safecall {
        api.getParadas()
    }.map { busStopDto ->
        val originalBusStops = busStopDto.toMutableList()
        originalBusStops.removeIf { it.stopNumber == "PAR" || it.addressName == "NOMBRE" }
        originalBusStops.toDomain()
    }

    override fun getBusDetailStop(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>> = flow {
        try {
            while (true) {
                coroutineContext.ensureActive()
                emit(
                    safecall {
                        api.getBusStopDetail(stopNumber)
                    }.map { it.toDomain() }
                )

                delay(20.seconds)
            }
        } catch (e: CancellationException) {
            emit(Result.Error(DataError.Local.CANCELLED_EXCEPTION))
        }
    }

    override suspend fun saveStops(busStop: BusStop) {
        busStopDao.insertBusStop(busStop.toEntity())
    }

    override fun getAllLocalBusStops(): Flow<List<BusStop>> = busStopDao.getBusStops().map { list ->
        list.map { entity ->
            entity.toDomain()
        }
    }

    override suspend fun deleteBusStop(busStop: BusStop) {
        busStopDao.deleteBusStop(busStop.toEntity())
    }
}
