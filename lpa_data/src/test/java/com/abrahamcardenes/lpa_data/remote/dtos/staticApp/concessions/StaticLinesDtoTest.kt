package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import com.abrahamcardenes.lpa_data.jsons.staticapp.StaticAppJsons
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.runner.junit4.BehaviorSpec
import kotlinx.serialization.json.Json

class StaticLinesDtoTest : BehaviorSpec({
    val json = Json { ignoreUnknownKeys = true }
    given("a successful API response") {
        then("maps response body to StaticLinesDto correctly") {
            val staticLinesDto = json.decodeFromString<StaticLinesDto>(StaticAppJsons.listResponse200)
            staticLinesDto shouldBeEqual StaticLinesDto(
                ResponseDto(
                    concessionsDto = ConcessionsDto(
                        concessions = listOf(
                            ConcessionStaticAppDto(
                                name = "Puerto - Hoya de La Plata",
                                commercial = "12",
                                color = "rgb(226, 0, 26)"
                            ),
                            ConcessionStaticAppDto(
                                name = "Mercado de Vegueta - Tres Palmas",
                                commercial = "13",
                                color = "rgb(185, 102, 161)"
                            ),
                            ConcessionStaticAppDto(
                                name = "Teatro - Tamaraceite",
                                commercial = "L3",
                                color = "rgb(188, 228, 246)"
                            )

                        )
                    )
                )

            )
        }
    }
})
