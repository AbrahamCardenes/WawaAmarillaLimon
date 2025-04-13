package com.abrahamcardenes.lpa_presentation.components.notifications

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.abrahamcardenes.lpa_presentation.uiModels.NotificationType

class NotificationTypeParamsProvider : PreviewParameterProvider<NotificationType> {
    override val values: Sequence<NotificationType>
        get() = NotificationType.entries.asSequence()
}
