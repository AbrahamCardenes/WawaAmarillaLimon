package com.abrahamcardenes.lpa_data.data

import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.EmptyResult
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.safecall
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.lpa_data.data.mappers.toDomain
import com.abrahamcardenes.lpa_data.data.mappers.toEntity
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BusStopsRepositoryImpl(
    private val api: ApiParadas,
    private val busStopDao: BusStopDao,
    private val coroutineScope: CoroutineScope,
    private val dispatchersProvider: DispatchersProvider,
    private val crashlyticsService: CrashlyticsService
) : BusStopsRepository {

    init {
        coroutineScope.launch(dispatchersProvider.IO) {
            getBusStops()
        }
    }

    override suspend fun getBusStops(): EmptyResult<DataError> = safecall {
        api.getParadas()
    }.map { busStopDto ->
        val originalBusStops = busStopDto.toMutableList()
        originalBusStops.removeIf { it.stopNumber == "PAR" || it.addressName == "NOMBRE" }
        val busStopsFromApi = originalBusStops.toDomain()
        val uniqueBusStops = busStopsFromApi.distinctBy { it.stopNumber }
            .sortedBy { it.stopNumber }

        busStopDao.upsertAll(uniqueBusStops.map { it.toEntity() })
    }.onError { error ->
        crashlyticsService.logException(Exception(error.toString()))
    }

    override fun getBusDetailStop(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>> = flow {
        try {
            while (true) {
                currentCoroutineContext().ensureActive()
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

    override suspend fun updateBusStopInDb(busStop: BusStop) {
        busStopDao.updateFavorite(stopNumber = busStop.stopNumber, isFavorite = busStop.isFavorite)
    }

    override fun getAllLocalBusStops(): Flow<List<BusStop>> = busStopDao.getBusStopsFlow().map { list ->
        list.map { entity ->
            entity.toDomain()
        }
    }
}
