package com.abrahamcardenes.macrobenchmark

import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BaselineProfilerGenerator {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun appStartUpAndSwipeUpAndDownSideToSideLikeARollerCoaster() {
        baselineProfileRule.collect(
            packageName = "com.abrahamcardenes.wawaamarillalimon",
            includeInStartupProfile = true
        ) {
            pressHome()
            startActivityAndWait()
            device.waitForIdle(5_000)

            // Just in case.
            // val output =ByteArrayOutputStream()
            // device.dumpWindowHierarchy(output)
            // println(output.toString("UTF-8"))

            val busStops = device.findObject(By.res("bus_stops_list"))

            busStops.fling(Direction.DOWN)
            busStops.fling(Direction.UP)
            busStops.fling(Direction.RIGHT)

            val emptyBusStopUi = device.findObject(By.res("empty_state"))
            emptyBusStopUi.fling(Direction.LEFT)

            val busStopsAfterBackFromFavorites = device.findObject(By.res("bus_stops_list"))
            busStopsAfterBackFromFavorites.fling(Direction.DOWN)
            busStopsAfterBackFromFavorites.fling(Direction.UP)
        }
    }
}
