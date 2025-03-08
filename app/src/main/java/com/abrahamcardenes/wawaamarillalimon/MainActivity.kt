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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abrahamcardenes.wawaamarillalimon.presentation.favorites.FavoritesStopsRoot
import com.abrahamcardenes.wawaamarillalimon.presentation.home.BusStopsScreenRoot
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.BusLines
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.BusStops
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.BusTimetable
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.FavoritesBusStops
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.getLabels
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.TimetableScreenRoot
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.travellers.TravellersScreenRoot
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectedItem by remember { mutableIntStateOf(0) }
            val items = listOf(BusStops, FavoritesBusStops, BusLines)
            val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Info)
            val unselectedIcons =
                listOf(Icons.Outlined.Home, Icons.Outlined.FavoriteBorder, Icons.Outlined.Info)

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

                        composable<BusLines> {
                            TravellersScreenRoot(
                                onNavigateToTimeTable = { busNumber ->
                                    navController.navigate(BusTimetable(busNumber = busNumber))
                                }
                            )
                        }

                        composable<BusTimetable> { navBackstackEntry ->
                            val busNumber = navBackstackEntry.arguments?.getInt("busNumber") ?: -1
                            TimetableScreenRoot(busNumber = busNumber, onNavigateBack = navController::navigateUp)
                        }
                    }
                }
            }
        }
    }
}
