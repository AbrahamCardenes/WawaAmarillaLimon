package com.abrahamcardenes.wawaamarillalimon.presentation.busesInfo.busRouteDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.presentation.busesInfo.busRouteDetail.uiModels.TimeUi
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromRGBAColor

@Composable
fun TimeBox(
    timeUi: TimeUi,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (timeUi.color ==
        RGBAColor(
            red = 245,
            green = 245,
            blue = 245,
            alpha = 1
        )
    ) {
        Color.Transparent
    } else {
        getComposeColorFromRGBAColor(timeUi.color).copy(alpha = 0.2f)
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = if (backgroundColor == Color.Transparent) MaterialTheme.colorScheme.onBackground else backgroundColor,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
            )
            .background(backgroundColor)
            .width(IntrinsicSize.Max)
            .padding(8.dp)
    ) {
        Text(
            timeUi.time,
            style = MaterialTheme.typography.titleSmall.copy(fontSize = 16.sp)
        )
    }
}

@PreviewLightDark
@Composable
fun TimeBoxPreview() {
    MaterialTheme {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            TimeBox(timeUi = TimeUi(time = "06:00", color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)))
            TimeBox(timeUi = TimeUi(time = "06:15", color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)))
            TimeBox(timeUi = TimeUi(time = "06:30", color = RGBAColor(red = 231, green = 157, blue = 214, alpha = 1)))
        }
    }

}