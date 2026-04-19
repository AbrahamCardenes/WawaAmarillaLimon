package com.abrahamcardenes.lpa_presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusDetailUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusStopsUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.SaveOrDeleteBusStopUseCase
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import com.abrahamcardenes.lpa_presentation.home.enums.BusStopOrigin
import com.abrahamcardenes.lpa_presentation.home.states.BusStopState
import com.abrahamcardenes.lpa_presentation.home.states.BusStopsUiState
import com.abrahamcardenes.lpa_presentation.home.states.FavoritesUiState
import com.abrahamcardenes.lpa_presentation.mappers.toUiStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.mappers.toBusStop
import com.abrahamcardenes.lpa_presentation.utils.removeNonSpacingMarks
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class BusStopsViewModel
@Inject constructor(
    private val getBusDetailUseCase: GetBusDetailUseCase,
    private val saveOrDeleteBusStopUseCase: SaveOrDeleteBusStopUseCase,
    private val crashlyticsService: CrashlyticsService,
    private val dispatchers: DispatchersProvider,
    private val getBusStopsUseCase: GetBusStopsUseCase
) : ViewModel() {
    private val _onlineBusStopsState = MutableStateFlow(BusStopsUiState())

    val onlineBusStopsState: StateFlow<BusStopsUiState> = _onlineBusStopsState.onStart {
        getBusStops()
    }.map { currentState ->
        val userInput = _onlineBusStopsState.value.userInput
        val filteredBusStops = currentState.busStops.filter { busStop ->
            busStop.stopNumber.toString().contains(other = userInput, ignoreCase = true) || busStop.addressName.removeNonSpacingMarks()
                .contains(
                    other = userInput,
                    ignoreCase = true
                )
        }
        currentState.copy(busStops = filteredBusStops)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BusStopsUiState())

    private val _favoriteBusStopsUiState = MutableStateFlow(FavoritesUiState())
    val favoriteBusStopsUiState: StateFlow<FavoritesUiState> = _favoriteBusStopsUiState
        .combine(_onlineBusStopsState) { currentState, onlineState ->
            val userInput = onlineState.userInput
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

    fun getBusStops() {
        updateState(BusStopState.Loading)
        getBusStopsUseCase().onEach { currentBusStops ->
            _onlineBusStopsState.update { state ->
                state.copy(busStops = currentBusStops.toUiStopDetail(), state = BusStopState.Success)
                    .keepCurrentExpandedStatus()
            }

            val favoriteBusStops = currentBusStops.filter { it.isFavorite }
            _favoriteBusStopsUiState.update {
                it.copy(busStops = favoriteBusStops.toUiStopDetail(), isLoading = false)
                    .keepCurrentExpandedStatus()
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun logErrorIfIsUnknown(it: DataError) {
        if (it is DataError.Remote.UnknownError) {
            crashlyticsService.logException(it.error ?: Exception("Null exception in Data Error Unknown"))
        }
    }

    fun getBusStopDetail(stopNumber: Int, origin: BusStopOrigin) {
        detailJob?.cancel()
        detailJob = viewModelScope.launch {
            closeOtherExpandedBusStopsExceptCurrentOneSelected(stopNumber, origin = origin)
            val fetchedStop = when (origin) {
                BusStopOrigin.ONLINE -> _onlineBusStopsState.value.busStops.find { it.stopNumber == stopNumber }
                BusStopOrigin.FAVORITES -> _favoriteBusStopsUiState.value.busStops.find { it.stopNumber == stopNumber }
            }
            if (fetchedStop == null) {
                crashlyticsService.logException(Exception("Could not find bus stop with number $stopNumber"))
                return@launch
            }

            if (fetchedStop.isExpanded) {
                updateBusStopDetail(
                    originalBusStop = fetchedStop,
                    availableBusLines = fetchedStop.availableBusLines,
                    isExpanded = false,
                    origin = origin
                )
                return@launch
            }
            getBusDetailUseCase(stopNumber).onEach { response ->
                response.onSuccess {
                    updateBusStopDetail(
                        originalBusStop = fetchedStop,
                        availableBusLines = it?.availableBusLines,
                        isExpanded = true,
                        origin = origin
                    )
                }
                    .onError {
                        updateBusStopDetail(
                            originalBusStop = fetchedStop,
                            availableBusLines = emptyList(),
                            isExpanded = true,
                            origin = origin
                        )
                        logErrorIfIsUnknown(it)
                    }
            }.collect()
        }
    }

    private fun closeOtherExpandedBusStopsExceptCurrentOneSelected(stopNumber: BusStopNumber, origin: BusStopOrigin) {
        val expandedBusStops = when (origin) {
            BusStopOrigin.ONLINE -> _onlineBusStopsState.value.busStops.filter { it.isExpanded && it.stopNumber != stopNumber }
            BusStopOrigin.FAVORITES -> _favoriteBusStopsUiState.value.busStops.filter { it.isExpanded && it.stopNumber != stopNumber }
        }
        expandedBusStops.forEach { busStop ->
            updateBusStopDetail(
                originalBusStop = busStop,
                availableBusLines = busStop.availableBusLines,
                isExpanded = false,
                origin = origin
            )
        }
    }

    private fun updateBusStopDetail(
        originalBusStop: UiBusStopDetail,
        availableBusLines: List<BusLine>?,
        isExpanded: Boolean,
        origin: BusStopOrigin
    ) {
        val updatedList = when (origin) {
            BusStopOrigin.ONLINE -> _onlineBusStopsState.value.busStops.toMutableList()
            BusStopOrigin.FAVORITES -> _favoriteBusStopsUiState.value.busStops.toMutableList()
        }

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

        when (origin) {
            BusStopOrigin.ONLINE -> {
                _onlineBusStopsState.update { state ->
                    state.copy(busStops = updatedList, currentExpandedBusStop = currentExpandedBusStop)
                }
            }

            BusStopOrigin.FAVORITES -> {
                _favoriteBusStopsUiState.update { state ->
                    state.copy(busStops = updatedList, currentExpandedBusStop = currentExpandedBusStop)
                }
            }
        }
    }

    fun updateUserInput(value: String) {
        _onlineBusStopsState.update {
            it.copy(userInput = value)
        }
    }

    fun saveOrDeleteBusStop(busStopUiBusStopDetail: UiBusStopDetail) {
        viewModelScope.launch(dispatchers.IO) {
            saveOrDeleteBusStopUseCase.invoke(busStopUiBusStopDetail.toBusStop())
        }
    }

    fun updateState(state: BusStopState) {
        if (_onlineBusStopsState.value.state == state) return
        _onlineBusStopsState.update {
            it.copy(state = state)
        }
    }

    fun onTabClick(busStopTab: BusStopTabs) {
        closeExpandedBusStops()
        _onlineBusStopsState.update { state ->
            state.copy(selectedTab = busStopTab)
        }
    }

    private fun closeExpandedBusStops() {
        detailJob?.cancel()
        val onlineBusStopSelected = _onlineBusStopsState.value.currentExpandedBusStop
        if (onlineBusStopSelected != null) {
            updateBusStopDetail(
                originalBusStop = onlineBusStopSelected,
                availableBusLines = onlineBusStopSelected.availableBusLines,
                isExpanded = false,
                origin = BusStopOrigin.ONLINE
            )
        }

        val favoriteBusStopSelected = _favoriteBusStopsUiState.value.currentExpandedBusStop
        if (favoriteBusStopSelected != null) {
            updateBusStopDetail(
                originalBusStop = favoriteBusStopSelected,
                availableBusLines = favoriteBusStopSelected.availableBusLines,
                isExpanded = false,
                origin = BusStopOrigin.FAVORITES
            )
        }
    }
}
