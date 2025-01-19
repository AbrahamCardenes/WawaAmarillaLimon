package com.abrahamcardenes.wawaamarillalimon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.presentation.BusStopsScreenRoot
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WawaAmarillaLimonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusStopsScreenRoot(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .navigationBarsPadding()
                            .imePadding()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}
