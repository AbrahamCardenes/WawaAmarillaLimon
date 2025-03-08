package com.abrahamcardenes.wawaamarillalimon.presentation.components.notifications

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.NotificationType

class NotificationTypeParamsProvider : PreviewParameterProvider<NotificationType> {
    override val values: Sequence<NotificationType>
        get() = NotificationType.entries.asSequence()
}
