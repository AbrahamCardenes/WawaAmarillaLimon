package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import com.abrahamcardenes.lpa_data.jsons.staticapp.StaticAppJsons
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.runner.junit4.BehaviorSpec
import kotlinx.serialization.json.Json

class BusRouteDtoTest : BehaviorSpec({
    val json = Json { ignoreUnknownKeys = true }

    given("a successful API response") {
        then("maps response body to BusRouteDto correctly") {
            val staticLinesDto = json.decodeFromString<BusRouteDto>(StaticAppJsons.detailResponse200)
            staticLinesDto shouldBeEqual BusRouteDto(
                line = "13",
                name = "Mercado de Vegueta - Tres Palmas",
                color = "rgb(185, 102, 161)",
                nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                variantsGo = listOf(
                    VariantsDto(
                        type = "A",
                        name = "Mercado de Vegueta - Tres Palmas",
                        color = "rgb(185, 102, 161)"
                    )
                ),
                variantsBack = listOf(
                    VariantsDto(
                        type = "B",
                        name = "Tres Palmas - Mercado de Vegueta",
                        color = "rgb(185, 102, 161)"
                    )
                ),
                stops = listOf(
                    RouteStopsDto(
                        number = "993",
                        name = "Mercado de Vegueta",
                        longitude = "-15.41300107",
                        latitude = "28.10265634",
                        node = "Mercado de Vegueta",
                        variants = listOf("A")
                    ),
                    RouteStopsDto(
                        number = "936",
                        name = "Tres Palmas",
                        latitude = "28.06985503",
                        longitude = "-15.42283358",
                        node = "Mercado de Vegueta",
                        variants = listOf("A")
                    ),
                    RouteStopsDto(
                        number = "936",
                        name = "Tres Palmas",
                        latitude = "28.06985503",
                        longitude = "-15.42283358",
                        node = "Tres Palmas",
                        variants = listOf("B")
                    ),
                    RouteStopsDto(
                        number = "993",
                        name = "Mercado de Vegueta",
                        latitude = "28.10265634",
                        longitude = "-15.41300107",
                        node = "Tres Palmas",
                        variants = listOf("B")
                    )
                ),
                schedule = listOf(
                    ScheduleStaticaDto(
                        node = "Mercado de Vegueta",
                        tipology = "De lunes a viernes",
                        time = "06:55",
                        color = "rgb(245, 245, 245)"
                    ),
                    ScheduleStaticaDto(
                        node = "Mercado de Vegueta",
                        tipology = "Sábado",
                        time = "08:05",
                        color = "rgba(0, 0, 0, 0)"
                    ),
                    ScheduleStaticaDto(
                        node = "Mercado de Vegueta",
                        tipology = "Domingo y festivo",
                        time = "07:50",
                        color = "rgb(245, 245, 245)"
                    ),

                    ScheduleStaticaDto(
                        node = "Tres Palmas",
                        tipology = "De lunes a viernes",
                        time = "06:10",
                        color = "rgb(245, 245, 245)"
                    ),
                    ScheduleStaticaDto(
                        node = "Tres Palmas",
                        tipology = "Sábado",
                        time = "07:10",
                        color = "rgb(245, 245, 245)",
                        variant = "F"
                    ),
                    ScheduleStaticaDto(
                        node = "Tres Palmas",
                        tipology = "Domingo y festivo",
                        time = "08:35",
                        color = "rgba(0, 0, 0, 0)"
                    )
                )
            )
        }

        `when`("the response contains empty values") {
            then("it should do the mapping putting default values") {
                val staticLinesDto = json.decodeFromString<BusRouteDto>(StaticAppJsons.detailResponse200WithEmptyLatituteLongitude)
                staticLinesDto shouldBeEqual BusRouteDto(
                    line = "13",
                    name = "Mercado de Vegueta - Tres Palmas",
                    color = "rgb(185, 102, 161)",
                    nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                    variantsGo = emptyList(),
                    variantsBack = emptyList(),
                    stops = listOf(
                        RouteStopsDto(
                            number = "993",
                            name = "Mercado de Vegueta",
                            longitude = "-15.41300107",
                            latitude = "",
                            node = "Mercado de Vegueta",
                            variants = listOf("A")
                        ),
                        RouteStopsDto(
                            number = "936",
                            name = "Tres Palmas",
                            longitude = "",
                            latitude = "28.06985503",
                            node = "Tres Palmas",
                            variants = listOf("B")
                        )
                    ),
                    schedule = emptyList()
                )
            }
        }
    }
})
