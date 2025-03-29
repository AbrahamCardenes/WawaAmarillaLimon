package com.abrahamcardenes.wawaamarillalimon.domain.models.travellers

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.WawaCardNumber

data class WawaCardBalance(
    val code: WawaCardNumber,
    val balance: Double,
    val date: String
)
