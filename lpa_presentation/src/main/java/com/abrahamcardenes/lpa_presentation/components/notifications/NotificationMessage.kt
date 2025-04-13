package com.abrahamcardenes.lpa_presentation.components.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.uiModels.NotificationType

@Composable
fun NotificationMessage(message: String, notificationType: NotificationType, modifier: Modifier = Modifier) {
    val contentColor = notificationType.getContentColor()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(notificationType.getBackgroundColor())
            .border(
                width = 1.dp,
                color = notificationType.getBorderColor(),
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .then(modifier)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = notificationType.getIcon(),
                contentDescription = null,
                tint = contentColor
            )
            Text(
                color = contentColor,
                text = message,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun NotificationMessagePreview(@PreviewParameter(NotificationTypeParamsProvider::class) notificationType: NotificationType) {
    WawaAmarillaLimonTheme {
        NotificationMessage(message = "Sábado, domingo y festivo no circula", notificationType = notificationType)
    }
}
