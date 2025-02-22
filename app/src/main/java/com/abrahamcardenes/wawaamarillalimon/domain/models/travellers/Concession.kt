package com.abrahamcardenes.wawaamarillalimon.domain.models.travellers

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.HexColorString

data class Concession(
    val busNumber: Int,
    val name: String,
    val commercialName: String,
    val color: HexColorString
)
