package com.abrahamcardenes.wawaamarillalimon.presentation.components.notifications

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.NotificationType

fun NotificationType.getIcon(): ImageVector = when (this) {
    NotificationType.INFO -> Icons.Outlined.Info
    NotificationType.WARNING -> Icons.Outlined.Warning
    NotificationType.ERROR -> Icons.Outlined.Close
}

@Composable
fun NotificationType.getBackgroundColor(): Color = when (this) {
    NotificationType.INFO -> MaterialTheme.colorScheme.surfaceVariant
    NotificationType.WARNING -> MaterialTheme.colorScheme.tertiaryContainer
    NotificationType.ERROR -> MaterialTheme.colorScheme.errorContainer
}

@Composable
fun NotificationType.getContentColor(): Color = when (this) {
    NotificationType.INFO -> MaterialTheme.colorScheme.onSurface
    NotificationType.WARNING -> MaterialTheme.colorScheme.onTertiaryContainer
    NotificationType.ERROR -> MaterialTheme.colorScheme.onErrorContainer
}

@Composable
fun NotificationType.getBorderColor(): Color = when (this) {
    NotificationType.INFO -> MaterialTheme.colorScheme.primary
    NotificationType.WARNING -> MaterialTheme.colorScheme.tertiary
    NotificationType.ERROR -> MaterialTheme.colorScheme.error
}
