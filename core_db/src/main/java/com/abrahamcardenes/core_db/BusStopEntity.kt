package com.abrahamcardenes.core_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bus_stop_table")
data class BusStopEntity(
    @PrimaryKey(autoGenerate = false)
    val stopNumber: BusStopNumber,
    val addressName: String
)
