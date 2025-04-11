package com.abrahamcardenes.wawaamarillalimon.data.mappers

import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopEntity
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.stops.BusLineDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.stops.BusStopDetailDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.stops.BusStopDto
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStopDetail

fun List<BusStopDto>.toDomain(): List<BusStop> = this.map {
    BusStop(
        addressName = it.addressName,
        stopNumber = it.stopNumber.toInt(),
        isSavedInDb = false
    )
}

fun BusStopDetailDto.toDomain(): BusStopDetail = BusStopDetail(
    addressName = this.addressName,
    availableBusLines = this.lines.linesToDomain()
)

fun List<BusLineDto>.linesToDomain(): List<BusLine> = this.map {
    BusLine(
        number = it.number.toString(),
        arrivalTimeIn = it.arrivalTimeIn,
        destination = it.destination
    )
}

fun BusStop.toEntity(): BusStopEntity = BusStopEntity(
    addressName = this.addressName,
    stopNumber = this.stopNumber
)

fun BusStopEntity.toDomain(): BusStop = BusStop(
    addressName = this.addressName,
    stopNumber = this.stopNumber,
    isSavedInDb = true
)
