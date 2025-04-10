package com.abrahamcardenes.wawaamarillalimon.domain.useCases.concessions

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository
import javax.inject.Inject

class GetBusRouteUseCase @Inject constructor(
    private val busRoutesRepository: BusRoutesRepository
) {
    suspend operator fun invoke(concessionId: String): Result<BusRoute, DataError> =
        busRoutesRepository.getBusRoutes(concessionId = concessionId.lowercase())
}
