package com.abrahamcardenes.wawaamarillalimon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.abrahamcardenes.lpa_domain.models.common.WawaColor.Companion.buildWawaColorFrom
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.BusRouteScreen
import com.abrahamcardenes.lpa_presentation.busesInfo.concessions.ConcessionsScreen
import com.abrahamcardenes.lpa_presentation.home.BusStopsScreenRoot
import com.abrahamcardenes.lpa_presentation.navigation.BusStops
import com.abrahamcardenes.lpa_presentation.navigation.BusTimetable
import com.abrahamcardenes.lpa_presentation.navigation.Concessions
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
                Box(
                    modifier = Modifier.semantics {
                        testTagsAsResourceId = true
                    }
                ) {
                    Scaffold(
                        bottomBar = {
                            WawaBottomBar(currentDestination = currentDestination.toString(), navController = navController)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = BusStops,
                            modifier =
                                Modifier
                                    .padding(innerPadding)
                                    .consumeWindowInsets(innerPadding),
                            enterTransition = {
                                showEnterTransition(
                                    fromRoute = initialState.destination.route,
                                    toRoute = targetState.destination.route
                                )
                            },
                            exitTransition = {
                                showExitTransition(
                                    fromRoute = initialState.destination.route,
                                    toRoute = targetState.destination.route
                                )
                            },
                            popEnterTransition = { fadeIn() },
                            popExitTransition = { fadeOut() }
                        ) {
                            composable<BusStops> {
                                BusStopsScreenRoot(
                                    modifier =
                                        Modifier
                                            .fillMaxSize()
                                )
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
                                    wawaColor = buildWawaColorFrom(rgbColorString),
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
}

private fun showEnterTransition(fromRoute: String?, toRoute: String?): EnterTransition =
    if (fromRoute.isTimetableRoute() || toRoute.isTimetableRoute()) {
        scaleIn(initialScale = 0.9f) + fadeIn()
    } else {
        val fromIndex = fromRoute.toBottomBarIndex()
        val toIndex = toRoute.toBottomBarIndex()
        when {
            toIndex > fromIndex -> slideInHorizontally { it } + fadeIn()
            toIndex < fromIndex -> slideInHorizontally { -it } + fadeIn()
            else -> fadeIn()
        }
    }

private fun showExitTransition(fromRoute: String?, toRoute: String?): ExitTransition =
    if (fromRoute.isTimetableRoute() || toRoute.isTimetableRoute()) {
        scaleOut(targetScale = 0.9f) + fadeOut()
    } else {
        val fromIndex = fromRoute.toBottomBarIndex()
        val toIndex = toRoute.toBottomBarIndex()
        when {
            toIndex > fromIndex -> slideOutHorizontally { -it } + fadeOut()
            toIndex < fromIndex -> slideOutHorizontally { it } + fadeOut()
            else -> fadeOut()
        }
    }

private fun String?.toBottomBarIndex(): Int = when (this) {
    BusStops::class.java.name -> 0
    Concessions::class.java.name -> 1
    WawaBalance::class.java.name -> 2
    else -> -1
}

private fun String?.isTimetableRoute(): Boolean = this?.substringBefore("/") == BusTimetable::class.java.name
