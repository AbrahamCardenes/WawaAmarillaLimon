package com.abrahamcardenes.wawaamarillalimon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abrahamcardenes.lpa_domain.valueObjects.toRGBAColor
import com.abrahamcardenes.lpa_domain.valueObjects.toRgbStringColor
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.BusRouteScreen
import com.abrahamcardenes.lpa_presentation.busesInfo.concessions.ConcessionsScreen
import com.abrahamcardenes.lpa_presentation.favorites.FavoritesStopsRoot
import com.abrahamcardenes.lpa_presentation.home.BusStopsScreenRoot
import com.abrahamcardenes.lpa_presentation.navigation.BusStops
import com.abrahamcardenes.lpa_presentation.navigation.BusTimetable
import com.abrahamcardenes.lpa_presentation.navigation.Concessions
import com.abrahamcardenes.lpa_presentation.navigation.FavoritesBusStops
import com.abrahamcardenes.lpa_presentation.navigation.WawaBalance
import com.abrahamcardenes.lpa_presentation.navigation.getLabels
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.wawaBalance.WawaBalanceScreenRoot
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val cardFilled = ImageVector.vectorResource(R.drawable.card_filled)
            val cardOutlined = ImageVector.vectorResource(R.drawable.card_outlined)
            var selectedItem by remember { mutableIntStateOf(0) }
            val items = listOf(BusStops, FavoritesBusStops, Concessions, WawaBalance)
            val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Info, cardFilled)
            val unselectedIcons =
                listOf(Icons.Outlined.Home, Icons.Outlined.FavoriteBorder, Icons.Outlined.Info, cardOutlined)

            val navController = rememberNavController()

            navController.addOnDestinationChangedListener(listener = { controller, destination, arguments ->
                val indexSelected = items.indexOfFirst {
                    destination.route == it::class.java.name
                }
                if (indexSelected != -1) {
                    selectedItem = indexSelected
                }
            })

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination?.route?.substringBefore("/")

            WawaAmarillaLimonTheme {
                Scaffold(
                    bottomBar = {
                        AnimatedContent(currentDestination.toString() !in listOf(BusTimetable::class.java.name)) { showBottomBar ->
                            if (showBottomBar) {
                                NavigationBar {
                                    items.forEachIndexed { index, item ->
                                        NavigationBarItem(
                                            icon = {
                                                Icon(
                                                    if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                                    contentDescription = item.getLabels()
                                                )
                                            },
                                            label = { Text(item.getLabels()) },
                                            selected = selectedItem == index,
                                            onClick = {
                                                selectedItem = index
                                                navController.navigate(item)
                                            }
                                        )
                                    }
                                }
                            }
                        }
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
                            FavoritesStopsRoot(
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
                                            rgbColorString = rgbaColor.toRgbStringColor()
                                        )
                                    )
                                }
                            )
                        }

                        composable<BusTimetable> { navBackstackEntry ->
                            val busNumber = navBackstackEntry.arguments?.getString("busNumber") ?: ""
                            val rgbColorString = navBackstackEntry.arguments?.getString("rgbColorString") ?: ""
                            BusRouteScreen(
                                busNumber = busNumber,
                                rgbaColor = rgbColorString.toRGBAColor(),
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
