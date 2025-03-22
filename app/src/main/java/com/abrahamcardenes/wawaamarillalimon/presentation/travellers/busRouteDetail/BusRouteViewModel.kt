package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionStop
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.concessions.GetBusRouteUseCase
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
        viewModelScope.launch {
            getBusRouteUseCase(concessionId = busIdNumber)
                .onSuccess { busRoute ->
                    _uiState.update { state ->
                        state.copy(
                            isLoading = false,
                            busRoute = busRoute
                        )
                    }
                }
                .onError {
                    println(it.toString())
                }
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
}
