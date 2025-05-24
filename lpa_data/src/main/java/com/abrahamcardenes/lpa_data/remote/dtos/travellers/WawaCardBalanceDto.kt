package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WawaCardBalanceDto(
    @field:Json(name = "codigo")
    val code: String,
    @field:Json(name = "saldo")
    val balance: String,
    @field:Json(name = "fecha")
    val date: String
)

fun WawaCardBalanceDto.toDomain(timestamp: Long): WawaCardBalance = WawaCardBalance(
    code = this.code,
    balance = this.balance.balanceToDouble(),
    date = this.date,
    lastLocalUpdate = timestamp
)

fun String.balanceToDouble(): Double = try {
    this.toDouble()
} catch (
    e: NumberFormatException
) {
    0.0
}
