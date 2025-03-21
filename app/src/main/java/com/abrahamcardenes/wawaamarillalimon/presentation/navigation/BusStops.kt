package com.abrahamcardenes.wawaamarillalimon.presentation.navigation

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.RgbaStringColor
import kotlinx.serialization.Serializable

interface NavRoutes

@Serializable
object BusStops : NavRoutes

@Serializable
object FavoritesBusStops : NavRoutes

@Serializable
object Concessions : NavRoutes

@Serializable
data class BusTimetable(val busNumber: String, val rgbColorString: RgbaStringColor) : NavRoutes

fun NavRoutes.getLabels(): String = when (this) {
    is BusStops -> "Paradas"
    is FavoritesBusStops -> "Favoritas"
    is Concessions -> "Concessions"
    else -> ""
}
