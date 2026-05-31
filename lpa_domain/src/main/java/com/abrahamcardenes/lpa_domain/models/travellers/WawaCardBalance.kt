package com.abrahamcardenes.lpa_domain.models.travellers

import com.abrahamcardenes.lpa_domain.valueObjects.WawaCardNumber
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class WawaCardBalance
@OptIn(ExperimentalUuidApi::class)
constructor(
    val uuid: Uuid,
    val code: WawaCardNumber,
    val balance: Double,
    val date: String
)
