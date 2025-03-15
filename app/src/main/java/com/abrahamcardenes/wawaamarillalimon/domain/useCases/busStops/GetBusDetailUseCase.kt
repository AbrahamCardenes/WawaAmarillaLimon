package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
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
