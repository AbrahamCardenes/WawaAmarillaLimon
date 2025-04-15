package com.abrahamcardenes.lpa_presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetAllBusStops
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusDetailUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.SaveOrDeleteBusStopUseCase
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import com.abrahamcardenes.lpa_presentation.mappers.toUiStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.mappers.toBusStop
import com.abrahamcardenes.lpa_presentation.utils.getRandomString
import com.abrahamcardenes.lpa_presentation.utils.removeNonSpacingMarks
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
class BusStopsViewModel
@Inject constructor(
    private val getAllBusStopsUseCase: GetAllBusStops,
    private val getBusDetailUseCase: GetBusDetailUseCase,
    private val saveOrDeleteBusStopUseCase: SaveOrDeleteBusStopUseCase,
    private val crashlyticsService: CrashlyticsService
) : ViewModel() {
    private val _uiState = MutableStateFlow(BusStopsUiState())
    val uiState: StateFlow<BusStopsUiState> = _uiState.onStart {
        getBusStops()
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
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BusStopsUiState())

    private var detailJob: Job? = null

    fun getBusStops() {
        updateState(BusStopState.Loading)
        viewModelScope.launch {
            getAllBusStopsUseCase()
                .collect { response ->
                    response
                        .onSuccess { currentBusStops ->
                            _uiState.update {
                                it.copy(busStops = currentBusStops.toUiStopDetail(), state = BusStopState.Success)
                                    .keepCurrentExpandedStatus()
                            }
                        }
                        .onError { it ->
                            _uiState.update { state ->
                                state.copy(errorMessage = getRandomString())
                            }
                            logErrorIfIsUnknown(it)
                            updateState(BusStopState.Error)
                        }
                }
        }
    }

    private suspend fun logErrorIfIsUnknown(it: DataError) {
        if (it is DataError.Remote.UnknownError) {
            crashlyticsService.logException(it.error ?: Exception("Null exception in Data Error Unknown"))
        }
    }

    fun getBusStopDetail(stopNumber: Int) {
        detailJob?.cancel()
        detailJob = viewModelScope.launch {
            closeOtherExpandedBusStopsExceptCurrentOneSelected(stopNumber)
            val fetchedStop = _uiState.value.busStops.find { it.stopNumber == stopNumber }
            if (fetchedStop == null) {
                crashlyticsService.logException(Exception("Could not find bus stop with number $stopNumber"))
                return@launch
            }

            if (fetchedStop.isExpanded) {
                updateBusStopDetail(
                    originalBusStop = fetchedStop,
                    availableBusLines = fetchedStop.availableBusLines,
                    isExpanded = false
                )
                return@launch
            }
            getBusDetailUseCase(stopNumber).onEach { response ->
                response.onSuccess {
                    updateBusStopDetail(
                        originalBusStop = fetchedStop,
                        availableBusLines = it?.availableBusLines,
                        isExpanded = true
                    )
                }
                    .onError {
                        updateBusStopDetail(
                            originalBusStop = fetchedStop,
                            availableBusLines = emptyList(),
                            isExpanded = true
                        )
                        logErrorIfIsUnknown(it)
                    }
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
        val updatedList = _uiState.value.busStops.toMutableList()
        val index = updatedList.indexOfFirst { originalBusStop.stopNumber == it.stopNumber }
        updatedList[index] = originalBusStop.copy(
            isExpanded = isExpanded,
            availableBusLines = availableBusLines
        )
        val currentExpandedBusStop = if (isExpanded) {
            updatedList[index]
        } else {
            null
        }
        _uiState.update { state ->
            state.copy(busStops = updatedList, currentExpandedBusStop = currentExpandedBusStop)
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

    fun updateState(state: BusStopState) {
        if (_uiState.value.state == state) return
        _uiState.update {
            it.copy(state = state)
        }
    }
}
