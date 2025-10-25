package com.abrahamcardenes.lpa_presentation.components.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme

@Composable
fun BusTextField(
    busTextFieldConfig: BusTextFieldConfig,
    onUserInput: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = busTextFieldConfig.value,
        onValueChange = { input ->
            onUserInput(input)
        },
        singleLine = true,
        label = {
            Text(
                text = busTextFieldConfig.label,
                style = MaterialTheme.typography.labelLarge
            )
        },
        trailingIcon = busTextFieldConfig.trailingIcon,
        isError = isError,
        keyboardOptions = KeyboardOptions(keyboardType = busTextFieldConfig.keyboardType),
        keyboardActions = busTextFieldConfig.keyboardActions,
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
                busTextFieldConfig = BusTextFieldConfig(
                    label = stringResource(R.string.search_bus_stop_textfield),
                    value = ""
                ),
                onUserInput = {}
            )
            BusTextField(
                busTextFieldConfig = BusTextFieldConfig(
                    label = stringResource(id = R.string.search_bus_stop_textfield),
                    value = "PASEO DE SAN JOSÉ"
                ),
                onUserInput = {}
            )
        }
    }
}
