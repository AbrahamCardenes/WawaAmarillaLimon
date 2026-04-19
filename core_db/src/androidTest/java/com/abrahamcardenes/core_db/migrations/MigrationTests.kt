package com.abrahamcardenes.core_db.migrations

import android.database.sqlite.SQLiteDatabase
import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.abrahamcardenes.core_db.fakes.busStopEntityFake
import com.abrahamcardenes.core_db.migrations.MigrationUtils.toContentValue
import com.abrahamcardenes.core_db.roomDb.RoomMigrations.MIGRATION_2_3
import com.abrahamcardenes.core_db.roomDb.WawaDatabase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MigrationTests {

    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
        instrumentation = InstrumentationRegistry.getInstrumentation(),
        databaseClass = WawaDatabase::class.java
    )

    @Test
    fun givenAMigrationFrom2To3ThenItShouldSetIsFavoriteToTrue() {
        val dbName = "wawa_database"
        runTest {
            helper.createDatabase(dbName, 2).apply {
                insert(
                    "bus_stop_table",
                    SQLiteDatabase.CONFLICT_REPLACE,
                    values = busStopEntityFake().toContentValue()
                )
                insert(
                    "bus_stop_table",
                    SQLiteDatabase.CONFLICT_REPLACE,
                    values = busStopEntityFake(stopNumber = 1, addressName = "TEATRO").toContentValue()
                )
            }.close()

            helper.runMigrationsAndValidate(
                dbName,
                3,
                true,
                MIGRATION_2_3
            )

            val migratedDb = MigrationUtils.getMigratedRoomDb(dbName, listOf(MIGRATION_2_3))

            val busStops = migratedDb.busStopDao().getBusStopsFlow().first()

            assertThat(busStops.size).isEqualTo(2)
            assertThat(busStops).isEqualTo(
                listOf(
                    busStopEntityFake(stopNumber = 1, addressName = "TEATRO").copy(isFavorite = true),
                    busStopEntityFake().copy(isFavorite = true)
                )
            )

            migratedDb.close()
        }
    }
}
