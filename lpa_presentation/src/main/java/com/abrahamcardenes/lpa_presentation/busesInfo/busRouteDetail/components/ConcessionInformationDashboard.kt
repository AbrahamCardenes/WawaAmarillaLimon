package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_domain.models.travellers.TimetableInfo
import com.abrahamcardenes.lpa_presentation.components.notifications.NotificationMessage
import com.abrahamcardenes.lpa_presentation.uiModels.NotificationType
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme

@Composable
fun ConcessionInformationDashboard(timetableInfo: TimetableInfo, modifier: Modifier = Modifier) {
    val infoMessage = timetableInfo.notes
    val warningMessage = timetableInfo.warning
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (infoMessage.isNotBlank()) {
            NotificationMessage(
                message = infoMessage,
                notificationType = NotificationType.INFO
            )
        }

        if (warningMessage.isNotBlank()) {
            NotificationMessage(
                message = warningMessage,
                notificationType = NotificationType.WARNING
            )
        }
    }
}

@Composable
@PreviewLightDark
fun TimetablePreview() {
    WawaAmarillaLimonTheme {
        ConcessionInformationDashboard(
            TimetableInfo(
                lineId = "Teatro - Hosp. Dr. Negrín (Exprés)",
                node = "Teatro",
                notes = "Sábado, domingo y festivo no circula",
                warning = "GC-1 Collapse",
                routes = emptyList(),
                concessionStops = emptyList(),
                schedules = emptyList()
            )
        )
    }
}
