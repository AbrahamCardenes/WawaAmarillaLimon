package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.core.map
import com.abrahamcardenes.wawaamarillalimon.core.safecall
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toEntity
import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopDao
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
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
        api.getParadas2()
    }.map { it ->
        val originalBusStops = it.toMutableList()
        originalBusStops.removeIf { it.stopNumber == "PAR" || it.addressName == "NOMBRE" }
        originalBusStops.toDomain()
    }

    override fun getBusDetailStop(stopNumber: BusStopNumber): Flow<BusStopDetail?> = flow {
        try {
            while (true) {
                coroutineContext.ensureActive()
                val busStopDetail = api.getBusStopDetail(stopNumber)
                emit(busStopDetail.toDomain())
                delay(20.seconds)
            }
        } catch (e: CancellationException) {
            emit(null)
        } catch (e: Exception) {
            println(e.stackTraceToString())
            emit(null)
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
