package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBusDetailUseCase @Inject constructor(private val repository: BusStopsRepository) {
     operator fun invoke(stopNumber: BusStopNumber): Flow<BusStopDetail?> {
        return repository.getBusDetailStop(stopNumber = stopNumber)
    }
}