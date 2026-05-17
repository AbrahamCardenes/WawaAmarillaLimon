package com.abrahamcardenes.lpa_data.remote.dtos.stops

import com.abrahamcardenes.lpa_data.jsons.paradas.ParadaJsons
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.runner.junit4.BehaviorSpec
import kotlinx.serialization.json.Json

class BusStopDtoTest : BehaviorSpec({
    val json = Json { ignoreUnknownKeys = true }

    given("Information from network bus stops endpoint") {
        `when`("The json contains unconventional values") {
            then("It should be mapped to those unconventional values") {
                val expected = BusStopDto(
                    addressName = "NOMBRE",
                    stopNumber = "PAR"
                )
                val busStopDtoFromJson = json.decodeFromString<BusStopDto>(ParadaJsons.busStopNamePar)
                busStopDtoFromJson shouldBeEqual expected
            }
        }

        `when`("The json contains simple values") {
            then("It should be mapped to those simple values") {
                val expected = BusStopDto(
                    addressName = "TEATRO",
                    stopNumber = "1"
                )
                val busStopDtoFromJson = json.decodeFromString<BusStopDto>(ParadaJsons.busStopBasic)
                busStopDtoFromJson shouldBeEqual expected
            }
        }

        `when`("The json contains a long long name") {
            then("It should be mapped correctly") {
                val expected = BusStopDto(
                    addressName = "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CENTRO INSULAR DE DEPORTES)",
                    stopNumber = "38"
                )
                val busStopDtoFromJson = json.decodeFromString<BusStopDto>(ParadaJsons.longlongBusStop)
                busStopDtoFromJson shouldBeEqual expected
            }
        }
    }
})
