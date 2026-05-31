package com.abrahamcardenes.core_db.migrations

import android.database.sqlite.SQLiteDatabase
import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.abrahamcardenes.core_db.cards.WawaBalanceEntity
import com.abrahamcardenes.core_db.fakes.busStopEntityFake
import com.abrahamcardenes.core_db.migrations.MigrationUtils.toContentValue
import com.abrahamcardenes.core_db.roomDb.RoomMigrations.MIGRATION_2_3
import com.abrahamcardenes.core_db.roomDb.RoomMigrations.MIGRATION_3_4
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
                4,
                true,
                MIGRATION_2_3,
                MIGRATION_3_4
            )

            val migratedDb = MigrationUtils.getMigratedRoomDb(dbName, listOf(MIGRATION_2_3, MIGRATION_3_4))

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

    @Test
    fun givenAMigrationFrom3To4ThenItShouldSetUuidV4Empty() {
        val dbName = "wawa_database"
        runTest {
            helper.createDatabase(dbName, 3).apply {
                insert(
                    "wawa_balance_table",
                    SQLiteDatabase.CONFLICT_REPLACE,
                    values = WawaBalanceEntity(
                        code = "57997",
                        balance = 0.9,
                        date = "03-08-2024 15:06:57",
                        uuidV4 = ""
                    ).toContentValue()
                )
            }.close()

            helper.runMigrationsAndValidate(
                dbName,
                4,
                true,
                MIGRATION_3_4
            )

            val migratedDb = MigrationUtils.getMigratedRoomDb(dbName, listOf(MIGRATION_3_4))

            val wawaBalanceList = migratedDb.wawaBalanceDao().getAll()

            assertThat(wawaBalanceList.size).isEqualTo(1)
            assertThat(wawaBalanceList).isEqualTo(
                listOf(
                    WawaBalanceEntity(
                        code = "57997",
                        balance = 0.9,
                        date = "03-08-2024 15:06:57",
                        uuidV4 = ""
                    )
                )
            )

            migratedDb.close()
        }
    }
}
