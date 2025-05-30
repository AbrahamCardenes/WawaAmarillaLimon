package com.abrahamcardenes.core_db.cards

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WawaBalanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWawaBalance(wawaBalance: WawaBalanceEntity)

    @Query("SELECT * FROM wawa_balance_table WHERE code = :code")
    suspend fun getWawaBalanceByCode(code: String): WawaBalanceEntity?

    @Query("DELETE FROM wawa_balance_table WHERE code = :code")
    suspend fun deleteWawaBalanceByCode(code: String)

    @Query("SELECT * FROM wawa_balance_table")
    fun getAllWawaBalances(): Flow<List<WawaBalanceEntity>>

    @Query("UPDATE wawa_balance_table SET balance = :balance WHERE code = :code")
    fun updateWawaBalanceByCode(code: String, balance: Double)

    suspend fun updateOrInsert(wawaBalance: WawaBalanceEntity) {
        val balance = getWawaBalanceByCode(wawaBalance.code)
        if (balance == null) {
            insertWawaBalance(wawaBalance = wawaBalance)
        } else updateWawaBalanceByCode(code = wawaBalance.code, balance = wawaBalance.balance)
    }
}
