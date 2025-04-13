package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
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
