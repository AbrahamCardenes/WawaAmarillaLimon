package com.abrahamcardenes.lpa_presentation.components.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme

@Composable
fun BusTextField(
    label: String,
    value: String,
    onUserInput: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
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
        isError = isError,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        keyboardActions = keyboardActions,
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
