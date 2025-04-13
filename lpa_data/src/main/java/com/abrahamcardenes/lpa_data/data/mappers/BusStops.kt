package com.abrahamcardenes.lpa_data.data.mappers

import com.abrahamcardenes.core_db.BusStopEntity
import com.abrahamcardenes.lpa_data.remote.dtos.stops.BusLineDto
import com.abrahamcardenes.lpa_data.remote.dtos.stops.BusStopDetailDto
import com.abrahamcardenes.lpa_data.remote.dtos.stops.BusStopDto
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail

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
