package com.abrahamcardenes.lpa_domain.fakes

import com.abrahamcardenes.lpa_domain.models.common.RGBAColor
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions

fun concessionsFake(): Concessions = Concessions(
    concessions = listOf(
        ConcessionDetails(
            name = "Puerto - Hoya de La Plata",
            commercial = "12",
            color = RGBAColor(
                red = 226,
                green = 0,
                blue = 26,
                alpha = 1f
            )
        ),
        ConcessionDetails(
            name = "Mercado de Vegueta - Tres Palmas",
            commercial = "13",
            color = RGBAColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1f
            )
        ),
        ConcessionDetails(
            name = "Teatro - Tamaraceite",
            commercial = "L3",
            color = RGBAColor(
                red = 188,
                green = 228,
                blue = 246,
                alpha = 1f
            )
        )
    )
)
