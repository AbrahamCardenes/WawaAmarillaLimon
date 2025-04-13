package com.abrahamcardenes.lpa_data.data.mappers

import com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions.ConcessionStaticAppDto
import com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions.ConcessionsDto
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.lpa_domain.valueObjects.toRGBAColor

fun ConcessionsDto.toDomain(): Concessions = Concessions(
    this.concessions.map { it.toDomain() }
)

fun ConcessionStaticAppDto.toDomain(): ConcessionDetails = ConcessionDetails(
    name = this.name,
    commercial = this.commercial,
    color = this.color.toRGBAColor()
)
