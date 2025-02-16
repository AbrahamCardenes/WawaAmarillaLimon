package com.abrahamcardenes.wawaamarillalimon.fakes

import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopEntity

fun busStopEntityFake(stopNumber: Int = 79, addressName: String = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)"): BusStopEntity = BusStopEntity(
    stopNumber = stopNumber,
    addressName = addressName
)
