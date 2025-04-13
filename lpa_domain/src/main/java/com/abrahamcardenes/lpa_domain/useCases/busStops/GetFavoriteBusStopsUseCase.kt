package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetFavoriteBusStopsUseCase @Inject constructor(private val busStopRepository: BusStopsRepository) {
    operator fun invoke(): Flow<List<BusStop>> = busStopRepository.getAllLocalBusStops()
}
