package com.abrahamcardenes.core_db.fakes

import com.abrahamcardenes.core_db.BusStopEntity

fun busStopEntityFake(stopNumber: Int = 79, addressName: String = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)"): BusStopEntity = BusStopEntity(
    stopNumber = stopNumber,
    addressName = addressName
)
