package com.abrahamcardenes.wawaamarillalimon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abrahamcardenes.wawaamarillalimon.presentation.BusStopsScreenRoot
import com.abrahamcardenes.wawaamarillalimon.presentation.components.lottie.LottieComponent
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.BusLines
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.BusStops
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.FavoritesBusStops
import com.abrahamcardenes.wawaamarillalimon.presentation.navigation.getLabels
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
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

            WawaAmarillaLimonTheme {
                Scaffold(
                    bottomBar = {
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
                            val preloaderLottieComposition by rememberLottieComposition(
                                LottieCompositionSpec.RawRes(
                                    R.raw.lottie_loader
                                )
                            )

                            val preloaderProgress by animateLottieCompositionAsState(
                                preloaderLottieComposition,
                                iterations = LottieConstants.IterateForever,
                                isPlaying = true,
                                useCompositionFrameRate = true
                            )
                            Box(
                                modifier =
                                Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                LottieComponent(
                                    lottieComposition = preloaderLottieComposition,
                                    preLoaderProgress = preloaderProgress,
                                    modifier = Modifier.size(200.dp)
                                )
                            }
                        }

                        composable<BusLines> {
                            Box(
                                modifier =
                                Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Listado de guaguas")
                            }
                        }
                    }
                }
            }
        }
    }
}
