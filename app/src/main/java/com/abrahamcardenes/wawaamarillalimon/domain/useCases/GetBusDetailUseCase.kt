package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetBusDetailUseCase
@Inject
constructor(
    private val repository: BusStopsRepository
) {
    operator fun invoke(stopNumber: BusStopNumber): Flow<BusStopDetail?> = repository.getBusDetailStop(stopNumber = stopNumber)
}
