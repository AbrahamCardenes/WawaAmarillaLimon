package com.abrahamcardenes.lpa_data.data.mappers.wawaBalance

import com.abrahamcardenes.core_db.cards.WawaBalanceEntity
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun WawaCardBalance.toEntity(): WawaBalanceEntity = WawaBalanceEntity(
    code = this.code,
    balance = this.balance,
    date = this.date,
    uuidV4 = this.uuid.toString()
)

@OptIn(ExperimentalUuidApi::class)
fun WawaBalanceEntity.toDomain(uuid: Uuid? = null): WawaCardBalance = WawaCardBalance(
    code = this.code,
    balance = this.balance,
    date = this.date,
    uuid = uuid ?: Uuid.parse(this.uuidV4)
)
