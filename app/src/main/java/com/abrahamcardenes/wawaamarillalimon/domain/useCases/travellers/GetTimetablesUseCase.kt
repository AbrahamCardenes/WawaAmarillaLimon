package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import javax.inject.Inject

class GetTimetablesUseCase @Inject constructor(
    private val repository: TravellersRepository,
    private val busRoutesRepository: BusRoutesRepository
) {
    suspend operator fun invoke(busIdNumber: BusIdNumber): Result<BusTimetables, DataError> {
        busRoutesRepository.getBusRoutes(busNumber = busIdNumber.toString().lowercase())

        return repository.getTimetables(busNumber = busIdNumber)
    }
}
