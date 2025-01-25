package com.abrahamcardenes.wawaamarillalimon.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusStopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBusStop(busStopEntity: BusStopEntity)

    @Delete
    suspend fun deleteBusStop(busStopEntity: BusStopEntity)

    @Query("SELECT * FROM busstopentity")
    fun getBusStops(): Flow<List<BusStopEntity>>
}
