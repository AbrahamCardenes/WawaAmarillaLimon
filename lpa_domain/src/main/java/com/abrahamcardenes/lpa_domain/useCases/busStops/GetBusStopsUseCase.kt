package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GetBusStopsUseCase @Inject constructor(
    private val busStopRepository: BusStopsRepository,
    private val dispatchersProvider: DispatchersProvider
) {
    operator fun invoke(): Flow<List<BusStop>> {
        val coroutine = CoroutineScope(SupervisorJob() + dispatchersProvider.IO)
        coroutine.launch(dispatchersProvider.IO) {
            busStopRepository.getBusStops()
        }

        return busStopRepository.getAllLocalBusStops()
    }
}
