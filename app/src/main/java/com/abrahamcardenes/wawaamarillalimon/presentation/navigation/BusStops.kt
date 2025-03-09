package com.abrahamcardenes.wawaamarillalimon.presentation.navigation

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.HexColorString
import kotlinx.serialization.Serializable

interface NavRoutes

@Serializable
object BusStops : NavRoutes

@Serializable
object FavoritesBusStops : NavRoutes

@Serializable
object BusLines : NavRoutes

@Serializable
data class BusTimetable(val busNumber: Int, val hexColorString: HexColorString) : NavRoutes

fun NavRoutes.getLabels(): String = when (this) {
    is BusStops -> "Paradas"
    is FavoritesBusStops -> "Favoritas"
    is BusLines -> "Lineas"
    else -> ""
}
