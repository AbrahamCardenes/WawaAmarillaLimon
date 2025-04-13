package com.abrahamcardenes.wawaamarillalimon.data.mappers

import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.lpa_domain.valueObjects.toRGBAColor
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.staticApp.concessions.ConcessionStaticAppDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.staticApp.concessions.ConcessionsDto

fun ConcessionsDto.toDomain(): Concessions = Concessions(
    this.concessions.map { it.toDomain() }
)

fun ConcessionStaticAppDto.toDomain(): ConcessionDetails = ConcessionDetails(
    name = this.name,
    commercial = this.commercial,
    color = this.color.toRGBAColor()
)
