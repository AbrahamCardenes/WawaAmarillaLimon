package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import javax.inject.Inject

class SaveOrDeleteBusStopUseCase @Inject constructor(private val busStopsRepository: BusStopsRepository) {
    suspend operator fun invoke(busStop: BusStop) {
        if (busStop.isSavedInDb) {
            busStopsRepository.deleteBusStop(busStop)
        } else {
            busStopsRepository.saveStops(busStop)
        }
    }
}
