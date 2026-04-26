package com.abrahamcardenes.core_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BusStopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(busStopEntity: List<BusStopEntity>)

    @Delete
    suspend fun deleteBusStop(busStopEntity: BusStopEntity)

    @Query("SELECT * FROM bus_stop_table")
    fun getBusStopsFlow(): Flow<List<BusStopEntity>>

    @Query("SELECT * FROM bus_stop_table")
    fun getBusStops(): List<BusStopEntity>

    @Query("SELECT * FROM bus_stop_table WHERE stopNumber = :stopNumber")
    fun getBusStopByNumber(stopNumber: Int): BusStopEntity?

    @Query("UPDATE bus_stop_table SET isFavorite = :isFavorite WHERE stopNumber = :stopNumber")
    suspend fun updateFavorite(stopNumber: Int, isFavorite: Boolean)

    @Update
    suspend fun updateAll(busStopsEntities: List<BusStopEntity>)

    suspend fun upsertAll(busStops: List<BusStopEntity>) {
        val existing = getBusStops().associateBy { it.stopNumber }
        val toInsert = mutableListOf<BusStopEntity>()
        val toUpdate = mutableListOf<BusStopEntity>()

        busStops.forEach { newBusStop ->
            val offlineStop = existing[newBusStop.stopNumber]
            if (offlineStop == null) {
                toInsert.add(newBusStop)
                return@forEach
            }
            if (offlineStop.addressName != newBusStop.addressName) {
                toUpdate.add(newBusStop.copy(isFavorite = offlineStop.isFavorite))
            }
        }

        insertAll(toInsert)
        updateAll(toUpdate)
    }
}
