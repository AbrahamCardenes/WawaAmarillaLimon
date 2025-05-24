package com.abrahamcardenes.lpa_data.data.mappers.wawaBalance

import com.abrahamcardenes.core_db.cards.WawaBalanceEntity
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance

fun WawaCardBalance.toEntity(): WawaBalanceEntity {
    return WawaBalanceEntity(
        code = this.code,
        balance = this.balance,
        lastLocalUpdate = this.lastLocalUpdate,
        date = this.date,
        addedAt = this.addedAt
    )
}


fun WawaBalanceEntity.toDomain(): WawaCardBalance {
    return WawaCardBalance(
        code = this.code,
        balance = this.balance,
        lastLocalUpdate = this.lastLocalUpdate,
        date = this.date,
        addedAt = this.addedAt
    )
}
