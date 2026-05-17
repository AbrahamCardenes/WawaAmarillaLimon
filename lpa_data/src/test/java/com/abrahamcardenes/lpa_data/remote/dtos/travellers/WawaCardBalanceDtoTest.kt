package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.abrahamcardenes.lpa_data.jsons.ogs.ogWawaCardBalanceJson
import com.abrahamcardenes.lpa_data.jsons.ogs.wawaCardBalanceJsonWithoutInfo
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.runner.junit4.BehaviorSpec
import kotlinx.serialization.json.Json

class WawaCardBalanceDtoTest : BehaviorSpec({
    val json = Json { ignoreUnknownKeys = true }

    given("A card balance json") {
        `when`("The json contains data") {
            then("it should map the values to WawaBalanceDto") {
                val wawaCardBalanceFromJson = json.decodeFromString<WawaCardBalanceDto>(ogWawaCardBalanceJson)
                wawaCardBalanceFromJson shouldBeEqual WawaCardBalanceDto(
                    code = "529491",
                    balance = "6.60",
                    date = "03-02-2025 11:30:21"
                )
            }
        }

        `when`("The json contains - as values") {
            then("it should map the values to WawaBalanceDto without crashing") {
                val wawaCardBalanceFromJson = json.decodeFromString<WawaCardBalanceDto>(wawaCardBalanceJsonWithoutInfo)
                wawaCardBalanceFromJson shouldBeEqual WawaCardBalanceDto(
                    code = "5294",
                    balance = "-",
                    date = "-"
                )
            }
        }
    }
})
