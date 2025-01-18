package com.abrahamcardenes.wawaamarillalimon.data.mappers

import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusStopDto
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop

fun List<BusStopDto>.toDomain(): List<BusStop> {
    return this.map {
        BusStop(
            addressName = it.addressName,
            stopNumber = it.stopNumber.toInt()
        )
    }
}