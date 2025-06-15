package com.abrahamcardenes.lpa_data.data.mappers.wawaBalance

import com.abrahamcardenes.core_db.cards.WawaBalanceEntity
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance

fun WawaCardBalance.toEntity(): WawaBalanceEntity = WawaBalanceEntity(
    code = this.code,
    balance = this.balance,
    date = this.date
)

fun WawaBalanceEntity.toDomain(): WawaCardBalance = WawaCardBalance(
    code = this.code,
    balance = this.balance,
    date = this.date
)
