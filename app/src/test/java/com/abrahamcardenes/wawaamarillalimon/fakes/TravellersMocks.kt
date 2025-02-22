package com.abrahamcardenes.wawaamarillalimon.fakes

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
