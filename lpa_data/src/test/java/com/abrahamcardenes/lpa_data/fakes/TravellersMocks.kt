package com.abrahamcardenes.lpa_data.fakes

import com.abrahamcardenes.lpa_domain.models.travellers.Concession
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance

fun mockedConcessions() = listOf(
    Concession(
        busNumber = 12,
        name = "PUERTO - HOYA DE LA PLATA",
        commercialName = "12",
        color = "#E2001A"
    ),
    Concession(
        busNumber = 13,
        name = "MERCADO DE VEGUETA - TRES PALMAS",
        commercialName = "13",
        color = "#B966A1"
    )
)

fun mockedWawaCardBalance(): WawaCardBalance = WawaCardBalance(
    code = "529491",
    balance = 6.60,
    date = "03-02-2025 11:30:21",
    lastLocalUpdate = 0L,
    addedAt = 0L
)
