package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun ConcessionNodesTabRow(onTabClick: (Int) -> Unit, tabSelected: Int, nodes: List<String>, modifier: Modifier = Modifier) {
    TabRow(
        selectedTabIndex = tabSelected,
        modifier = modifier
    ) {
        nodes.forEachIndexed { index, node ->
            Tab(
                selected = tabSelected == index,
                onClick = {
                    onTabClick(index)
                }
            ) {
                Text(
                    text = node,
                    style = MaterialTheme.typography.titleMedium
                        .copy(textAlign = TextAlign.Center),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun ConcessionNodesTabRowPreview() {
    WawaAmarillaLimonTheme {
        ConcessionNodesTabRow(
            onTabClick = {},
            tabSelected = 0,
            nodes = listOf("Teatro", "Hospital Dr. Negrín")
        )
    }
}
