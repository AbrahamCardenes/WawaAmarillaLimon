package com.abrahamcardenes.wawaamarillalimon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.GetAllBusStops
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
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
class BusStopsViewModel @Inject constructor(private val getAllBusStopsUseCase: GetAllBusStops) :
    ViewModel() {

    private val _uiState = MutableStateFlow(BusStopsUiState())

    val uiState: StateFlow<BusStopsUiState> = _uiState.onStart {
        getBusStops()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BusStopsUiState())

    private fun getBusStops() {
        viewModelScope.launch {
            val currentBusStops = getAllBusStopsUseCase()
            _uiState.update {
                it.copy(busStops = currentBusStops.toUiStopDetail())
            }
        }
    }

    fun getBusStopDetail(stopNumber: Int) {
        viewModelScope.launch {

            val fetchedStop = _uiState.value.busStops.find { it.stopNumber == stopNumber }

            if (fetchedStop == null) {
                // TODO: Handle error
                return@launch
            }

            val updatedBusStop = fetchedStop.copy(
                isExpanded = !fetchedStop.isExpanded,
                availableBusLines = fakeLines()
            )
            val updatedList = _uiState.value.busStops.toMutableList()
            updatedList[updatedList.indexOf(fetchedStop)] = updatedBusStop
            _uiState.update { it ->
                it.copy(busStops = updatedList)
            }
        }
    }

    private fun fakeLines(): List<BusLine> {
        return listOf(
            BusLine(number = 13, arrivalTimeIn = "10min", destination = "TRES PALMAS"),
            BusLine(number = 13, arrivalTimeIn = "20min", destination = "TRES PALMAS"),
            BusLine(
                number = 64,
                arrivalTimeIn = "20min",
                destination = "HOYA DE LA PLATA"
            )
        )
    }

}


data class BusStopsUiState(
    val busStops: List<UiBusStopDetail> = emptyList(),
)

fun List<BusStop>.toUiStopDetail(): List<UiBusStopDetail> {
    return this.map {
        UiBusStopDetail(
            addressName = it.addressName,
            stopNumber = it.stopNumber,
            availableBusLines = null,
            isExpanded = false
        )
    }
}