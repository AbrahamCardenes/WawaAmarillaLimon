package com.abrahamcardenes.core_db.roomDb

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object RoomMigrations {

    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL(
                "ALTER TABLE bus_stop_table ADD COLUMN isFavorite INTEGER NOT NULL DEFAULT 0"
            )
            db.execSQL(
                "UPDATE bus_stop_table SET isFavorite = 1"
            )
        }
    }
}
