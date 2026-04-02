package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WawaCardBalanceDto(
    @SerialName(value = "codigo")
    val code: String,
    @SerialName(value = "saldo")
    val balance: String,
    @SerialName(value = "fecha")
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
