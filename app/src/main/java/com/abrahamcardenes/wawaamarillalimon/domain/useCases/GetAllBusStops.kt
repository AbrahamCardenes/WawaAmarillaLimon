package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import javax.inject.Inject

class GetAllBusStops @Inject constructor(private val repository: BusStopsRepository) {
    suspend operator fun invoke(): List<BusStop> {
        return repository.getBusStops()
            .distinctBy { it.stopNumber }
            .sortedBy { it.stopNumber }
    }
}