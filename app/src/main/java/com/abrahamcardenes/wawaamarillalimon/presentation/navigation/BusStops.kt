package com.abrahamcardenes.wawaamarillalimon.presentation.navigation

import kotlinx.serialization.Serializable

interface NavRoutes

@Serializable
object BusStops : NavRoutes

@Serializable
object FavoritesBusStops : NavRoutes

@Serializable
object BusLines : NavRoutes

fun NavRoutes.getLabels(): String = when (this) {
    is BusStops -> "Paradas"
    is FavoritesBusStops -> "Favoritas"
    is BusLines -> "Lineas"
    else -> ""
}
