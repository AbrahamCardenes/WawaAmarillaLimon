package com.abrahamcardenes.wawaamarillalimon.ui

import androidx.compose.animation.AnimatedContent
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.abrahamcardenes.lpa_presentation.navigation.BusStops
import com.abrahamcardenes.lpa_presentation.navigation.BusTimetable
import com.abrahamcardenes.lpa_presentation.navigation.Concessions
import com.abrahamcardenes.lpa_presentation.navigation.FavoritesBusStops
import com.abrahamcardenes.lpa_presentation.navigation.WawaBalance
import com.abrahamcardenes.lpa_presentation.navigation.getLabels
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.wawaamarillalimon.R

@Composable
fun WawaBottomBar(currentDestination: String, navController: NavController) {
    val cardFilled = ImageVector.vectorResource(R.drawable.card_filled)
    val cardOutlined = ImageVector.vectorResource(R.drawable.card_outlined)
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Info, cardFilled)
    val unselectedIcons =
        listOf(Icons.Outlined.Home, Icons.Outlined.FavoriteBorder, Icons.Outlined.Info, cardOutlined)

    val bottomBarRoutes = listOf(BusStops, FavoritesBusStops, Concessions, WawaBalance)
    var selectedRoute by remember { mutableIntStateOf(0) }

    navController.addOnDestinationChangedListener(listener = { _, destination, _ ->
        val indexSelected = bottomBarRoutes.indexOfFirst {
            destination.route == it::class.java.name
        }
        if (indexSelected != -1) {
            selectedRoute = indexSelected
        }
    })

    AnimatedContent(currentDestination !in listOf(BusTimetable::class.java.name)) { showBottomBar ->
        if (showBottomBar) {
            NavigationBar {
                bottomBarRoutes.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selectedRoute == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = item.getLabels()
                            )
                        },
                        label = { Text(item.getLabels()) },
                        selected = selectedRoute == index,
                        onClick = {
                            selectedRoute = index
                            navController.navigate(item)
                        }
                    )
                }
            }
        }
    }
}

@Composable()
@PreviewLightDark()
fun WawaBottomBarPreview() {
    WawaAmarillaLimonTheme {
        WawaBottomBar(currentDestination = BusStops::class.java.name, navController = rememberNavController())
    }
}
