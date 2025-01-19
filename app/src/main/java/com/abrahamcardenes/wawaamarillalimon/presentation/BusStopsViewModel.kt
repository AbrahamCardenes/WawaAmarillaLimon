package com.abrahamcardenes.wawaamarillalimon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.GetAllBusStops
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.GetBusDetailUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import com.abrahamcardenes.wawaamarillalimon.presentation.mappers.toUiStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.removeNonSpacingMarks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusStopsViewModel @Inject constructor(
    private val getAllBusStopsUseCase: GetAllBusStops,
    private val getBusDetailUseCase: GetBusDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BusStopsUiState())
    val uiState: StateFlow<BusStopsUiState> = _uiState.onStart {
        getBusStops()
    }.map { currentState ->
        val userInput = _uiState.value.userInput
        val filteredBusStops = currentState.busStops.filter { busStop ->
            busStop.stopNumber.toString()
                .contains(other = userInput, ignoreCase = true) ||
                    busStop.addressName.removeNonSpacingMarks().contains(
                        other = userInput, ignoreCase = true
                    )
        }
        currentState.copy(busStops = filteredBusStops)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BusStopsUiState())

    private var detailJob: Job? = null

    private fun getBusStops() {
        viewModelScope.launch {
            val currentBusStops = getAllBusStopsUseCase()
            _uiState.update {
                it.copy(busStops = currentBusStops.toUiStopDetail())
            }
        }
    }

    fun getBusStopDetail(stopNumber: Int) {
        detailJob?.cancel()
        detailJob = viewModelScope.launch {

            closeOtherExpandedBusStopsExceptCurrentOneSelected(stopNumber)

            val fetchedStop = _uiState.value.busStops.find { it.stopNumber == stopNumber }
            if (fetchedStop == null) {
                // TODO: Handle error
                return@launch
            }

            val isExpanded = !fetchedStop.isExpanded

            if (!isExpanded) {
                updateBusStopDetail(
                    originalBusStop = fetchedStop,
                    availableBusLines = fetchedStop.availableBusLines,
                    isExpanded = isExpanded
                )
                return@launch
            }

            getBusDetailUseCase(stopNumber)
                .onEach {
                    updateBusStopDetail(
                        originalBusStop = fetchedStop,
                        availableBusLines = it?.availableBusLines,
                        isExpanded = isExpanded
                    )
                }.collect()
        }
    }

    private fun closeOtherExpandedBusStopsExceptCurrentOneSelected(stopNumber: BusStopNumber) {
        val expandedBusStops =
            _uiState.value.busStops.filter { it.isExpanded && it.stopNumber != stopNumber }
        expandedBusStops.forEach { busStop ->
            updateBusStopDetail(
                originalBusStop = busStop,
                availableBusLines = busStop.availableBusLines,
                isExpanded = false
            )
        }
    }


    private fun updateBusStopDetail(
        originalBusStop: UiBusStopDetail,
        availableBusLines: List<BusLine>?,
        isExpanded: Boolean
    ) {
        val updatedList = _uiState.value.busStops.toMutableList()
        val index = updatedList.indexOfFirst { originalBusStop.stopNumber == it.stopNumber }
        updatedList[index] = originalBusStop.copy(
            isExpanded = isExpanded,
            availableBusLines = availableBusLines
        )

        _uiState.update { state ->
            state.copy(busStops = updatedList)
        }
    }

    fun updateUserInput(value: String) {
        _uiState.update {
            it.copy(userInput = value)
        }
    }
}


