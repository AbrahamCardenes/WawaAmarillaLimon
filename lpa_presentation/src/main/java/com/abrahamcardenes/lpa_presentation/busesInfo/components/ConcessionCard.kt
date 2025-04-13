package com.abrahamcardenes.lpa_presentation.busesInfo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.utils.getComposeColorFromRGBAColor

@Composable
fun ConcessionCard(concession: ConcessionDetails, onClick: (String, RGBAColor) -> Unit, modifier: Modifier = Modifier) {
    val dynamicColor = getComposeColorFromRGBAColor(concession.color)
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            onClick(
                concession.commercial,
                concession.color
            )
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BusLineNumberCircle(
                dynamicColor = dynamicColor,
                commercialName = concession.commercial,
                modifier = Modifier
                    .size(50.dp)
            )

            Column {
                Text(
                    text = concession.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun ConcessionCardPreview() {
    WawaAmarillaLimonTheme {
        ConcessionCard(
            onClick = { _, _ -> },
            concession = ConcessionDetails(
                commercial = "91",
                name = "Teatro - Tamaraceite",
                color = RGBAColor(
                    red = 0,
                    green = 144,
                    blue = 54,
                    alpha = 1
                )
            )
        )
    }
}
