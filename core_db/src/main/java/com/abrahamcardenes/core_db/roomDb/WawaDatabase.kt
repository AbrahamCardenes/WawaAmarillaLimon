package com.abrahamcardenes.core_db.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.core_db.BusStopEntity

@Database(entities = [BusStopEntity::class], version = 1, exportSchema = false)
abstract class WawaDatabase : RoomDatabase() {
    abstract fun busStopDao(): BusStopDao
}
