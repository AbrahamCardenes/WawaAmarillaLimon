package com.abrahamcardenes.wawaamarillalimon.domain.models.travellers

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.HexColorString

data class RoutePaths(
    val type: String,
    val hexColor: HexColorString,
    val notes: String
)
