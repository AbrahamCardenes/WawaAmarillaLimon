package com.abrahamcardenes.wawaamarillalimon.presentation.components.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BusTextField(
    label: String,
    value: String,
    onUserInput: (String) -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = { Icon(imageVector = Icons.Outlined.Search, contentDescription = null) }
) {
    OutlinedTextField(
        value = value,
        onValueChange = { input ->
            onUserInput(input)
        },
        singleLine = true,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge
            )
        },
        trailingIcon = trailingIcon,
        modifier =
        modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.ime)
    )
}

@Preview(showBackground = true)
@Composable
fun BusTextFieldPreview() {
    WawaAmarillaLimonTheme {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            BusTextField(
                label = stringResource(R.string.search_bus_stop_textfield),
                value = "",
                onUserInput = {}
            )
            BusTextField(
                label = stringResource(R.string.search_bus_stop_textfield),
                value = "PASEO DE SAN JOSÉ",
                onUserInput = {}
            )
        }
    }
}
