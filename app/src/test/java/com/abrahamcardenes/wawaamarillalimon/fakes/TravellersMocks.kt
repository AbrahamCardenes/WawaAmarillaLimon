package com.abrahamcardenes.wawaamarillalimon.fakes

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession

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
