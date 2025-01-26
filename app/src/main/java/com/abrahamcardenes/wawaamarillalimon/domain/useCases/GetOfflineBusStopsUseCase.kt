package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetOfflineBusStopsUseCase @Inject constructor(private val busStopsRepository: BusStopsRepository) {
    operator fun invoke(): Flow<List<BusStop>> = busStopsRepository.getAllLocalBusStops()
}
