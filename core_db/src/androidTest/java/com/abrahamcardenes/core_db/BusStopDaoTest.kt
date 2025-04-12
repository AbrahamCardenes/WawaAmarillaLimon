package com.abrahamcardenes.core_db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.abrahamcardenes.core_db.fakes.busStopEntityFake
import com.abrahamcardenes.core_db.roomDb.WawaDatabase
import com.google.common.truth.Truth.assertThat
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
        dao.insertBusStop(
            busStopEntity = busStopEntityFake()
        )
        assertThat(dao.getBusStops().first().size).isEqualTo(1)
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStopEntityFake())
    }

    @Test
    fun givenADoubleInsertionItShouldReturnOnlyOne() = runTest {
        dao.insertBusStop(
            busStopEntity = busStopEntityFake()
        )
        dao.insertBusStop(
            busStopEntity = busStopEntityFake()
        )
        assertThat(dao.getBusStops().first().size).isEqualTo(1)
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStopEntityFake())
    }

    @Test
    fun givenTwoDifferentInsertionsItShouldReturnTwoBusStops() = runTest {
        val busStop79 = busStopEntityFake()
        val busStop1 = busStopEntityFake(stopNumber = 1, addressName = "TEATRO")

        dao.insertBusStop(
            busStopEntity = busStop79
        )

        dao.insertBusStop(
            busStopEntity = busStop1
        )
        assertThat(dao.getBusStops().first()).isEqualTo(
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

        dao.insertBusStop(
            busStopEntity = busStop79
        )

        dao.insertBusStop(
            busStopEntity = busStop1
        )
        assertThat(dao.getBusStops().first()).isEqualTo(
            listOf(
                busStop1,
                busStop79
            )
        )
        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isEqualTo(busStop79)
        assertThat(dao.getBusStopByNumber(stopNumber = 1)).isEqualTo(busStop1)

        dao.deleteBusStop(busStop79)
        assertThat(dao.getBusStops().first()).isEqualTo(
            listOf(
                busStop1
            )
        )

        assertThat(dao.getBusStopByNumber(stopNumber = 79)).isNull()
    }
}
