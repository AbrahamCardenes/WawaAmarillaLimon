package com.abrahamcardenes.wawaamarillalimon.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow

@Dao
interface BusStopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBusStop(busStopEntity: BusStopEntity)

    @Delete
    suspend fun deleteBusStop(busStopEntity: BusStopEntity)

    @Query("SELECT * FROM bus_stop_table")
    fun getBusStops(): Flow<List<BusStopEntity>>

    @Query("SELECT * FROM bus_stop_table WHERE stopNumber = :stopNumber")
    fun getBusStopByNumber(stopNumber: BusStopNumber): BusStopEntity?
}
