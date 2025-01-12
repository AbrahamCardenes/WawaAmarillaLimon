package com.abrahamcardenes.wawaamarillalimon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.domain.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusStopsViewModel @Inject constructor(private val repository: BusStopsRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(BusStopsUiState())

    val uiState: StateFlow<BusStopsUiState> = _uiState.onStart {
        getBusStops()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BusStopsUiState())

    private fun getBusStops() {
        viewModelScope.launch {
            val currentBusStops = repository.getStops()

            _uiState.update {
                it.copy(busStops = currentBusStops)
            }
        }
    }

}


data class BusStopsUiState(
    val busStops: List<BusStop> = emptyList(),
)