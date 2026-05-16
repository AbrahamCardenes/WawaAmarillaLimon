package com.abrahamcardenes.lpa_data.remote.dtos.stops

import com.abrahamcardenes.lpa_data.jsons.paradas.ParadaJsons
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.runner.junit4.BehaviorSpec
import kotlinx.serialization.json.Json

class BusLineDtoTest : BehaviorSpec({
    val json = Json { ignoreUnknownKeys = true }
    context("The application receives bus stop information") {
        given("a json with lines incoming") {
            val busStopIncomingLinesToDecode = ParadaJsons.busStopDetailWithLinesComing
            then("it should map all the fields to dto model") {
                val expected = BusStopDetailDto(
                    addressName = "IND. JOSÉ SÁNCHEZ PEÑATE (C.C. LAS ARENAS)",
                    lines = listOf(
                        BusLineDto(
                            number = "17",
                            arrivalTimeIn = ">>",
                            destination = "TEATRO"
                        ),
                        // WHO IS NUMBER 92? And why does not have any destination?!
                        BusLineDto(
                            number = "92",
                            arrivalTimeIn = "8min",
                            destination = ""
                        ),
                        BusLineDto(
                            number = "65",
                            arrivalTimeIn = "22min",
                            destination = "PUERTO"
                        ),
                        BusLineDto(
                            number = "L2",
                            arrivalTimeIn = "27min",
                            destination = "CDAD ALTA-STA CAT"
                        )
                    )
                )
                val busStopDetailDto = json.decodeFromString<BusStopDetailDto>(busStopIncomingLinesToDecode)
                busStopDetailDto shouldBeEqual expected
            }
        }

        given("a json without lines incoming") {
            val busStopWithoutLinesIncoming = ParadaJsons.busStopDetailWithoutLinesIncoming
            then("it should map with empty lines") {
                val expected = BusStopDetailDto(
                    addressName = "LEONARDO TORRIANI (ZÁRATE)",
                    lines = emptyList()
                )
                val busStopDetailDto = json.decodeFromString<BusStopDetailDto>(busStopWithoutLinesIncoming)
                busStopDetailDto shouldBeEqual expected
            }
        }
    }
})
