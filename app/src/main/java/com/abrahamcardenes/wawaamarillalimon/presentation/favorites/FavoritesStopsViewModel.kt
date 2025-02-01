package com.abrahamcardenes.wawaamarillalimon.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.GetBusDetailUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.GetFavoriteBusStopsUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.SaveOrDeleteBusStopUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import com.abrahamcardenes.wawaamarillalimon.presentation.mappers.toUiStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.mappers.toBusStop
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.removeNonSpacingMarks
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
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

@HiltViewModel
class FavoritesStopsViewModel
@Inject constructor(
    private val getFavoriteBusStopsUseCase: GetFavoriteBusStopsUseCase,
    private val getBusDetailUseCase: GetBusDetailUseCase,
    private val saveOrDeleteBusStopUseCase: SaveOrDeleteBusStopUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.onStart {
        getOfflineBusStops()
    }.map { currentState ->
        val userInput = _uiState.value.userInput
        val filteredBusStops = currentState.busStops.filter { busStop ->
            busStop.stopNumber.toString().contains(other = userInput, ignoreCase = true) || busStop.addressName.removeNonSpacingMarks()
                .contains(
                    other = userInput,
                    ignoreCase = true
                )
        }
        currentState.copy(busStops = filteredBusStops)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), FavoritesUiState())

    private var detailJob: Job? = null

    private fun getOfflineBusStops() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            getFavoriteBusStopsUseCase()
                .collect { currentBusStops ->
                    _uiState.update {
                        it.copy(busStops = currentBusStops.toUiStopDetail(), isLoading = false)
                            .keepCurrentExpandedStatus()
                    }
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

            getBusDetailUseCase(stopNumber).onEach {
                updateBusStopDetail(
                    originalBusStop = fetchedStop,
                    availableBusLines = it?.availableBusLines,
                    isExpanded = isExpanded
                )
            }.collect()
        }
    }

    private fun closeOtherExpandedBusStopsExceptCurrentOneSelected(stopNumber: BusStopNumber) {
        val expandedBusStops = _uiState.value.busStops.filter { it.isExpanded && it.stopNumber != stopNumber }
        expandedBusStops.forEach { busStop ->
            updateBusStopDetail(
                originalBusStop = busStop,
                availableBusLines = busStop.availableBusLines,
                isExpanded = false
            )
        }
    }

    private fun updateBusStopDetail(originalBusStop: UiBusStopDetail, availableBusLines: List<BusLine>?, isExpanded: Boolean) {
        _uiState.update { state ->
            val updatedBusStops = state.busStops.map { busStop ->
                if (busStop.stopNumber == originalBusStop.stopNumber) {
                    busStop.copy(isExpanded = isExpanded, availableBusLines = availableBusLines)
                } else {
                    busStop
                }
            }
            state.copy(
                busStops = updatedBusStops,
                currentExpandedBusStop = if (isExpanded) updatedBusStops.find { it.stopNumber == originalBusStop.stopNumber } else null
            )
        }
    }

    fun updateUserInput(value: String) {
        _uiState.update {
            it.copy(userInput = value)
        }
    }

    fun saveOrDeleteBusStop(busStopUiBusStopDetail: UiBusStopDetail) {
        viewModelScope.launch(Dispatchers.IO) {
            saveOrDeleteBusStopUseCase.invoke(busStopUiBusStopDetail.toBusStop())
        }
    }
}
