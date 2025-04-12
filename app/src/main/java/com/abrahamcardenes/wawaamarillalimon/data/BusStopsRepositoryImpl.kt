package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.core.network.safecall
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toEntity
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
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
    }.map { it ->
        val originalBusStops = it.toMutableList()
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
