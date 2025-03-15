package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import javax.inject.Inject

class GetBusRouteUseCase @Inject constructor(
    private val busRoutesRepository: BusRoutesRepository
) {
    suspend operator fun invoke(busIdNumber: BusIdNumber): Result<BusRoute, DataError> =
        busRoutesRepository.getBusRoutes(busNumber = busIdNumber.toString().lowercase())
}
