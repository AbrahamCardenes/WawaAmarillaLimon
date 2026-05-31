package com.abrahamcardenes.lpa_data.fakes

import com.abrahamcardenes.core_db.cards.WawaBalanceEntity
import com.abrahamcardenes.lpa_domain.models.travellers.Concession
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

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

@OptIn(ExperimentalUuidApi::class)
fun mockedWawaCardBalance(): WawaCardBalance = WawaCardBalance(
    code = "529491",
    balance = 6.60,
    date = "03-02-2025 11:30:21",
    uuid = Uuid.parse(uuidStringHardcoded())
)

@OptIn(ExperimentalUuidApi::class)
fun mockedWawaCardBalanceEntity(): WawaBalanceEntity = WawaBalanceEntity(
    code = "529491",
    balance = 6.60,
    date = "03-02-2025 11:30:21",
    uuidV4 = uuidStringHardcoded()
)

fun uuidStringHardcoded() = "0b01fb6f-f01d-4657-b51a-35372320045f"
