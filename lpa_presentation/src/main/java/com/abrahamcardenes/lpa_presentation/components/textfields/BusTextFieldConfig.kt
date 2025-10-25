package com.abrahamcardenes.lpa_presentation.components.textfields

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

data class BusTextFieldConfig(
    val label: String,
    val value: String,
    val isError: Boolean = false,
    val keyboardType: KeyboardType = KeyboardType.Companion.Text,
    val keyboardActions: KeyboardActions = KeyboardActions.Companion.Default,
    val trailingIcon: @Composable (() -> Unit)? = {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = null
        )
    }
)
