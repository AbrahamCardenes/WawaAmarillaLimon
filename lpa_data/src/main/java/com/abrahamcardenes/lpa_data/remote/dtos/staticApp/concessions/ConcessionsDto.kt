package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConcessionsDto(
    @field:Json(name = "Concesion")
    val concessions: List<ConcessionStaticAppDto>
)
