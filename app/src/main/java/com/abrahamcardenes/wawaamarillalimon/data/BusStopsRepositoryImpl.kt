package com.abrahamcardenes.wawaamarillalimon.data

import android.util.Log
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.datasource.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.seconds

class BusStopsRepositoryImpl(
    private val api: ApiParadas
) : BusStopsRepository {
    override suspend fun getBusStops(): List<BusStop> {
        return try {
            val originalBusStops = api.getParadas().toMutableList()
            originalBusStops.removeIf { it.stopNumber == "PAR" || it.addressName == "NOMBRE" }
            originalBusStops.toDomain()
        } catch (e: Exception) {
            println(e.stackTraceToString())
            emptyList()
        }
    }

    override fun getBusDetailStop(stopNumber: BusStopNumber): Flow<BusStopDetail?> {
        return flow {
            try {
                while (true) {
                    coroutineContext.ensureActive()
                    val busStopDetail = api.getBusStopDetail(stopNumber)
                    Log.d("BusStopsRepositoryImpl", "getBusDetailStop: $busStopDetail")
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
    }
}

