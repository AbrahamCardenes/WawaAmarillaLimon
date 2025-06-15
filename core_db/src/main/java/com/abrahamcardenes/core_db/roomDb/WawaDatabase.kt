package com.abrahamcardenes.core_db.roomDb

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.core_db.BusStopEntity
import com.abrahamcardenes.core_db.cards.WawaBalanceDao
import com.abrahamcardenes.core_db.cards.WawaBalanceEntity

@Database(
    entities = [BusStopEntity::class, WawaBalanceEntity::class],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
abstract class WawaDatabase : RoomDatabase() {
    abstract fun busStopDao(): BusStopDao
    abstract fun wawaBalanceDao(): WawaBalanceDao
}
