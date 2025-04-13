package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetBusDetailUseCase
@Inject
constructor(
    private val repository: BusStopsRepository
) {
    operator fun invoke(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>> =
        repository.getBusDetailStop(stopNumber = stopNumber)
}
