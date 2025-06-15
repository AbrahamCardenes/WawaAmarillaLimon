package com.abrahamcardenes.core_db.cards

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wawa_balance_table")
data class WawaBalanceEntity(
    @PrimaryKey(autoGenerate = false)
    val code: String,
    val balance: Double,
    val date: String
)
