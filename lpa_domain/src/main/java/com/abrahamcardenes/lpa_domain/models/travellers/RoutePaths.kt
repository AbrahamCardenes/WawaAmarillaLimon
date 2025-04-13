package com.abrahamcardenes.lpa_domain.models.travellers

import com.abrahamcardenes.lpa_domain.valueObjects.HexColorString

data class RoutePaths(
    val type: String,
    val hexColor: HexColorString,
    val notes: String
)
