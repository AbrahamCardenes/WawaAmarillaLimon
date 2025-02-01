package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetFavoriteBusStopsUseCase @Inject constructor(private val busStopRepository: BusStopsRepository) {
    operator fun invoke(): Flow<List<BusStop>> = busStopRepository.getAllLocalBusStops()
}
