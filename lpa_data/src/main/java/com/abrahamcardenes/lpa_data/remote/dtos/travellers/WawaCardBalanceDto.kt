package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
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

@OptIn(ExperimentalUuidApi::class)
fun WawaCardBalanceDto.toDomain(uuid: Uuid): WawaCardBalance = WawaCardBalance(
    code = this.code,
    balance = this.balance.balanceToDouble(),
    date = this.date,
    uuid = uuid
)

fun String.balanceToDouble(): Double = try {
    this.toDouble()
} catch (
    e: NumberFormatException
) {
    0.0
}
