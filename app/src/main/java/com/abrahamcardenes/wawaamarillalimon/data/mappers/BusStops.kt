package com.abrahamcardenes.wawaamarillalimon.data.mappers

import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusLineDto
import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusStopDetailDto
import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusStopDto
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail

fun List<BusStopDto>.toDomain(): List<BusStop> = this.map {
    BusStop(
        addressName = it.addressName,
        stopNumber = it.stopNumber.toInt()
    )
}

fun BusStopDetailDto.toDomain(): BusStopDetail = BusStopDetail(
    addressName = this.addressName,
    availableBusLines = this.lines.linesToDomain()
)

fun List<BusLineDto>.linesToDomain(): List<BusLine> = this.map {
    BusLine(
        number = it.number.toInt(),
        arrivalTimeIn = it.arrivalTimeIn,
        destination = it.destination
    )
}
