package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.components

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
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromHexHtml
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun ConcessionCard(concession: Concession, onClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    val dynamicColor = getComposeColorFromHexHtml(concession.color)
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            onClick(concession.busNumber)
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
                commercialName = concession.commercialName,
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
            onClick = {},
            concession = Concession(
                busNumber = 91,
                name = "Nombre",
                commercialName = "L2",
                color = "#FFFFFF"
            )
        )
    }
}
