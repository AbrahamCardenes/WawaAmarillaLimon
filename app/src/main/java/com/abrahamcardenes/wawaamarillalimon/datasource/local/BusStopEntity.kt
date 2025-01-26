package com.abrahamcardenes.wawaamarillalimon.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber

@Entity(tableName = "bus_stop_table")
data class BusStopEntity(
    @PrimaryKey(autoGenerate = false)
    val stopNumber: BusStopNumber,
    val addressName: String
)
