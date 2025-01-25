package com.abrahamcardenes.wawaamarillalimon.datasource.local.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopDao
import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopEntity

@Database(entities = [BusStopEntity::class], version = 1, exportSchema = false)
abstract class WawaDatabase : RoomDatabase() {
    abstract fun busStopDao(): BusStopDao
}
