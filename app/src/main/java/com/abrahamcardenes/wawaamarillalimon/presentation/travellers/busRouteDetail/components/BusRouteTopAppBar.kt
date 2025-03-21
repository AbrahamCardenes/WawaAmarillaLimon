package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.HexColorString
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.components.BusLineNumberCircle
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromHexHtml
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromRGBAColor
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BusRouteTopAppBar(
    commercial: String,
    rgbaColor: RGBAColor,
    title: String,
    onNavigateBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    val circleSize by remember {
        derivedStateOf {
            lerp(start = 70.dp, stop = 50.dp, fraction = scrollBehavior.state.collapsedFraction)
        }
    }

    val titleTextSize by remember {
        derivedStateOf {
            lerp(start = 24.sp, stop = 17.sp, fraction = scrollBehavior.state.collapsedFraction)
        }
    }

    LargeTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                BusLineNumberCircle(
                    dynamicColor = getComposeColorFromRGBAColor(rgbaColor),
                    commercialName = commercial.toString(),
                    modifier = Modifier.size(circleSize)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall.copy(fontSize = titleTextSize),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .animateContentSize()
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@ExperimentalMaterial3Api
@Composable
@PreviewLightDark
fun TimetableTopBarPreview() {
    WawaAmarillaLimonTheme {
        val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

        BusRouteTopAppBar(
            commercial = "1",
            rgbaColor = RGBAColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1
            ),
            title = "Mercado de Vegueta - Tres Palmas",
            onNavigateBack = { },
            scrollBehavior = scrollBehavior
        )
    }
}
