package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import javax.inject.Inject

class GetTimetablesUseCase @Inject constructor(
    private val repository: TravellersRepository
) {
    suspend operator fun invoke(busIdNumber: BusIdNumber): Result<BusTimetables, DataError> =
        repository.getTimetables(busNumber = busIdNumber)
}
