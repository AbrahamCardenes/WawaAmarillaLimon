package com.abrahamcardenes.core_db.migrations

import android.content.ContentValues
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.test.platform.app.InstrumentationRegistry
import com.abrahamcardenes.core_db.BusStopEntity
import com.abrahamcardenes.core_db.roomDb.WawaDatabase

object MigrationUtils {

    fun getMigratedRoomDb(dbName: String, migrations: List<Migration>): WawaDatabase = Room.databaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        WawaDatabase::class.java,
        dbName
    ).addMigrations(
        *migrations.toTypedArray()
    ).build().apply {
        openHelper.writableDatabase
    }

    fun BusStopEntity.toContentValue(): ContentValues {
        val values = ContentValues()
        values.put("stopNumber", this.stopNumber)
        values.put("addressName", this.addressName)
        return values
    }
}
