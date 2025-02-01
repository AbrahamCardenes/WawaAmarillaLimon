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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BusTextField(value: String, onUserInput: (String) -> Unit, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = { input ->
            onUserInput(input)
        },
        singleLine = true,
        label = {
            Text(
                "Introduzca el número o dirección de la parada",
                style = MaterialTheme.typography.labelLarge
            )
        },
        trailingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
        },
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
                value = "",
                onUserInput = {}
            )
            BusTextField(
                value = "PASEO DE SAN JOSÉ",
                onUserInput = {}
            )
        }
    }
}
