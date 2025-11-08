package com.abrahamcardenes.wawaamarillalimon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.abrahamcardenes.lpa_domain.valueObjects.toRgbString
import com.abrahamcardenes.lpa_domain.valueObjects.toRgba
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.BusRouteScreen
import com.abrahamcardenes.lpa_presentation.busesInfo.concessions.ConcessionsScreen
import com.abrahamcardenes.lpa_presentation.favorites.FavoritesStopsRoot
import com.abrahamcardenes.lpa_presentation.home.BusStopsScreenRoot
import com.abrahamcardenes.lpa_presentation.navigation.BusStops
import com.abrahamcardenes.lpa_presentation.navigation.BusTimetable
import com.abrahamcardenes.lpa_presentation.navigation.Concessions
import com.abrahamcardenes.lpa_presentation.navigation.FavoritesBusStops
import com.abrahamcardenes.lpa_presentation.navigation.WawaBalance
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.wawaBalance.WawaBalanceScreenRoot
import com.abrahamcardenes.wawaamarillalimon.ui.WawaBottomBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination?.route?.substringBefore("/")

            WawaAmarillaLimonTheme {
                Scaffold(
                    bottomBar = {
                        WawaBottomBar(currentDestination = currentDestination.toString(), navController = navController)
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = BusStops,
                        modifier =
                        Modifier
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
                    ) {
                        composable<BusStops> {
                            BusStopsScreenRoot(
                                modifier =
                                Modifier
                                    .fillMaxSize()
                            )
                        }

                        composable<FavoritesBusStops> {
                            FavoritesStopsRoot()
                        }

                        composable<Concessions> {
                            ConcessionsScreen(
                                onNavigateToTimeTable = { busNumber, rgbaColor ->
                                    navController.navigate(
                                        BusTimetable(
                                            busNumber = busNumber,
                                            rgbColorString = rgbaColor.toRgbString()
                                        )
                                    )
                                }
                            )
                        }

                        composable<BusTimetable> { navBackstackEntry ->
                            val busTimetable = navBackstackEntry.toRoute<BusTimetable>()
                            val busNumber = busTimetable.busNumber
                            val rgbColorString = busTimetable.rgbColorString
                            BusRouteScreen(
                                busNumber = busNumber,
                                rgbaColor = rgbColorString.toRgba(),
                                onNavigateBack = navController::navigateUp
                            )
                        }

                        composable<WawaBalance> {
                            WawaBalanceScreenRoot()
                        }
                    }
                }
            }
        }
    }
}
