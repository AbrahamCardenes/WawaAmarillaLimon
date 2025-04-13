package com.abrahamcardenes.lpa_domain.models.travellers

import com.abrahamcardenes.lpa_domain.valueObjects.HexColorString

data class Concession(
    val busNumber: Int,
    val name: String,
    val commercialName: String,
    val color: HexColorString
)
