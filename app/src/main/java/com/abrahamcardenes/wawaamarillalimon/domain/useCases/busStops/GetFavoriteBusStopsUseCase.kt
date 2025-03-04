package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetFavoriteBusStopsUseCase @Inject constructor(private val busStopRepository: BusStopsRepository) {
    operator fun invoke(): Flow<List<BusStop>> = busStopRepository.getAllLocalBusStops()
}
