package com.abrahamcardenes.core_db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.abrahamcardenes.core_db.fakes.busStopEntityFake
import com.abrahamcardenes.core_db.roomDb.WawaDatabase
import com.google.common.truth.Truth.assertThat
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class BusStopDaoTest {
    private lateinit var database: WawaDatabase
    private lateinit var dao: BusStopDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WawaDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.busStopDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun givenAnInsertionItShouldReturnIt() = runTest {
        dao.upsertAll(
            busStops = listOf(busStopEntityFake())
        )
        assertThat(dao.getBusStopsFlow().first().size).isEqualTo(1)
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStopEntityFake())
    }

    @Test
    fun givenADoubleInsertionItShouldReturnOnlyOne() = runTest {
        dao.upsertAll(
            busStops = listOf(busStopEntityFake())
        )
        dao.upsertAll(
            busStops = listOf(busStopEntityFake())
        )
        assertThat(dao.getBusStopsFlow().first().size).isEqualTo(1)
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStopEntityFake())
    }

    @Test
    fun givenTwoDifferentInsertionsItShouldReturnTwoBusStops() = runTest {
        val busStop79 = busStopEntityFake()
        val busStop1 = busStopEntityFake(stopNumber = 1, addressName = "TEATRO")

        dao.upsertAll(
            busStops = listOf(busStop79)
        )

        dao.upsertAll(
            busStops = listOf(busStop1)
        )

        assertThat(dao.getBusStopsFlow().first()).isEqualTo(
            listOf(
                busStop1,
                busStop79
            )
        )
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStop79)
        assertThat(dao.getBusStopByNumber(stopNumber = 1)).isEqualTo(busStop1)
    }

    @Test
    fun givenADeleteCallItShouldDeleteTheBusStop() = runTest {
        val busStop79 = busStopEntityFake()
        val busStop1 = busStopEntityFake(stopNumber = 1, addressName = "TEATRO")

        dao.upsertAll(
            busStops = listOf(busStop79)
        )

        dao.upsertAll(
            busStops = listOf(busStop1)
        )
        assertThat(dao.getBusStopsFlow().first()).isEqualTo(
            listOf(
                busStop1,
                busStop79
            )
        )
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStop79)
        assertThat(dao.getBusStopByNumber(stopNumber = 1)).isEqualTo(busStop1)

        dao.deleteBusStop(busStop79)
        assertThat(dao.getBusStopsFlow().first()).isEqualTo(
            listOf(
                busStop1
            )
        )

        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isNull()
    }

    @Test
    fun givenTwoStopsWhenAddingUpdatingItShouldNotChangeFavoriteValue() = runTest {
        val busStop79 = busStopEntityFake()
        val busStop1 = busStopEntityFake(stopNumber = 1, addressName = "TEATRO")
        val expected = listOf(busStop1, busStop79.copy(isFavorite = true))

        dao.upsertAll(
            busStops = listOf(busStop79.copy(isFavorite = true), busStop1)
        )

        dao.getBusStopsFlow().first() shouldBe expected

        dao.upsertAll(
            busStops = listOf(busStop79, busStop1)
        )

        dao.getBusStopsFlow().first() shouldBe expected
    }
}
