package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers

import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance
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

fun WawaCardBalanceDto.toDomain(): WawaCardBalance = WawaCardBalance(
    code = this.code,
    balance = this.balance.balanceToDouble(),
    date = this.date
)

fun String.balanceToDouble(): Double = try {
    this.toDouble()
} catch (
    e: NumberFormatException
) {
    0.0
}
