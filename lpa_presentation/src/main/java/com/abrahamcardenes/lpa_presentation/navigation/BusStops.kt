package com.abrahamcardenes.lpa_presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.abrahamcardenes.lpa_domain.valueObjects.RgbString
import com.abrahamcardenes.lpa_presentation.R
import kotlinx.serialization.Serializable

interface NavRoutes

@Serializable
object BusStops : NavRoutes

@Serializable
object FavoritesBusStops : NavRoutes

@Serializable
object Concessions : NavRoutes

@Serializable
object WawaBalance : NavRoutes

@Serializable
data class BusTimetable(val busNumber: String, val rgbColorString: RgbString) : NavRoutes

@Composable
fun NavRoutes.getLabels(): String = when (this) {
    is BusStops -> stringResource(R.string.stops)
    is FavoritesBusStops -> stringResource(R.string.favorites)
    is Concessions -> stringResource(R.string.lines)
    is WawaBalance -> stringResource(R.string.card_balance)
    else -> ""
}
