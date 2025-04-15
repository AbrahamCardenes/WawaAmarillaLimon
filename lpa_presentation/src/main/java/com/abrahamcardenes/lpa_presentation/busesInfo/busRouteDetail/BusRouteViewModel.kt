package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_domain.models.travellers.ConcessionStop
import com.abrahamcardenes.lpa_domain.useCases.concessions.GetBusRouteUseCase
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.ScheduleUi
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.TimeUi
import com.abrahamcardenes.lpa_presentation.utils.getRandomString
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class BusRouteViewModel @Inject constructor(
    private val getBusRouteUseCase: GetBusRouteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BusRouteUiState())
    val uiState = _uiState.asStateFlow()

    private val _availableRouteStops = MutableStateFlow<List<ConcessionStop>>(emptyList())
    private val _availableBackRouteStops = MutableStateFlow<List<ConcessionStop>>(emptyList())
    private val _busSchedules = MutableStateFlow<List<ScheduleUi>>(emptyList())

    val availableRouteStops = _availableRouteStops.combine(uiState) { _, state ->
        if (state.busRoute == null || state.selectedIndex == 1) {
            emptyList()
        } else {
            getAvailableRoutesFor(
                possibleVariants = state.busRoute.variantsGo,
                state = state
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val availableBackRouteStops = _availableBackRouteStops.combine(uiState) { _, state ->
        if (state.busRoute == null || state.selectedIndex == 0) {
            emptyList()
        } else {
            getAvailableRoutesFor(
                possibleVariants = state.busRoute.variantsBack,
                state = state
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val busSchedules = _busSchedules.combine(uiState) { schedules, state ->
        val currentBusRoute = state.busRoute
        if (currentBusRoute == null) return@combine emptyList()

        val uiSchedules = getSchedulesUiGroupedByTypology(currentBusRoute, state)

        if (state.selectedVariant != null) {
            val filteredVariants = uiSchedules.map {
                it.copy(time = it.time.filter { time -> time.variant == state.selectedVariant.type || time.variant == "" })
            }.filter { it.time.isNotEmpty() }

            return@combine filteredVariants
        }

        uiSchedules
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    private fun getAvailableRoutesFor(possibleVariants: List<Variants>, state: BusRouteUiState) = when {
        state.selectedVariant == null -> {
            state.busRoute!!.stops.filter {
                it.variants.any { variantLetter ->
                    possibleVariants.map { defaultVariant -> defaultVariant.type }.contains(variantLetter)
                }
            }
        }

        else -> {
            state.busRoute!!.stops.filter {
                it.variants.contains(state.selectedVariant.type)
            }
        }
    }

    fun getBusRoute(busIdNumber: String) {
        updateUiState(BusRouteState.Loading)
        viewModelScope.launch {
            getBusRouteUseCase(concessionId = busIdNumber)
                .onSuccess { busRoute ->
                    _uiState.update { state ->
                        state.copy(
                            busRoute = busRoute,
                            state = BusRouteState.Success
                        )
                    }
                }
                .onError {
                    _uiState.update { state ->
                        state.copy(errorMessage = getRandomString())
                    }
                    updateUiState(BusRouteState.Error)
                }
        }
    }

    private fun getSchedulesUiGroupedByTypology(currentBusRoute: BusRoute, state: BusRouteUiState): List<ScheduleUi> {
        val schedulesByNode = currentBusRoute.schedules.filter { it.node == currentBusRoute.nodes[state.selectedIndex] }
        val schedulesGroupedByTypology = schedulesByNode.groupBy { it.typology }

        return schedulesGroupedByTypology.map {
            ScheduleUi(
                node = currentBusRoute.nodes[state.selectedIndex],
                typology = it.key,
                time = it.value.map { schedule ->
                    TimeUi(
                        time = schedule.time,
                        color = schedule.color,
                        variant = schedule.variantLetter ?: ""
                    )
                }
            )
        }
    }

    fun onIndexSelection(value: Int) {
        _uiState.update { state ->
            state.copy(
                selectedIndex = value,
                selectedVariant = null
            )
        }
    }

    fun onRouteSelection(variant: Variants) {
        _uiState.update { state ->
            state.copy(selectedVariant = variant)
        }
    }

    fun openOrCloseScheduleDialog() {
        _uiState.update { state ->
            state.copy(showDialog = !state.showDialog)
        }
    }

    fun updateUiState(value: BusRouteState) {
        _uiState.update { state ->
            state.copy(state = value)
        }
    }
}
