package com.abrahamcardenes.lpa_domain.fakes

import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
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

fun mockedConcessionsDetails() = listOf(
    ConcessionDetails(
        commercial = "12",
        name = "PUERTO - HOYA DE LA PLATA",
        color = RGBAColor(red = 226, green = 0, blue = 26, alpha = 1)
    ),
    ConcessionDetails(
        commercial = "13",
        name = "MERCADO DE VEGUETA - TRES PALMAS",
        color = RGBAColor(red = 185, green = 102, blue = 161, alpha = 1)
    )
)

fun mockedWawaCardBalance(): WawaCardBalance = WawaCardBalance(
    code = "529491",
    balance = 6.60,
    date = "03-02-2025 11:30:21",
    lastLocalUpdate = 1748000199979
)
