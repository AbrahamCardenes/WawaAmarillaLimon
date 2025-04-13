package com.abrahamcardenes.lpa_domain.models.travellers

import com.abrahamcardenes.lpa_domain.valueObjects.WawaCardNumber

data class WawaCardBalance(
    val code: WawaCardNumber,
    val balance: Double,
    val date: String
)
