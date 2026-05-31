package com.abrahamcardenes.lpa_presentation.fakes

import com.abrahamcardenes.lpa_domain.models.common.WawaColor
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

fun mockedConcessionsDetails() = listOf(
    ConcessionDetails(
        commercial = "12",
        name = "PUERTO - HOYA DE LA PLATA",
        color = WawaColor(red = 226, green = 0, blue = 26, alpha = 1f)
    ),
    ConcessionDetails(
        commercial = "13",
        name = "MERCADO DE VEGUETA - TRES PALMAS",
        color = WawaColor(red = 185, green = 102, blue = 161, alpha = 1f)
    )
)

@OptIn(ExperimentalUuidApi::class)
fun mockedWawaCardBalance(): WawaCardBalance = WawaCardBalance(
    code = "529491",
    balance = 6.60,
    date = "03-02-2025 11:30:21",
    uuid = Uuid.parse("0b01fb6f-f01d-4657-b51a-35372320045f")
)
