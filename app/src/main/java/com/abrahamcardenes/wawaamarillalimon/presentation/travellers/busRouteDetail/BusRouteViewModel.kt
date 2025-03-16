package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionStop
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetBusRouteUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// TODO: Unit tests
@HiltViewModel
class BusRouteViewModel @Inject constructor(
    private val getBusRouteUseCase: GetBusRouteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BusRouteUiState())
    val uiState = _uiState.asStateFlow()

    private val _availableRouteStops = MutableStateFlow<List<ConcessionStop>>(emptyList())
    private val _availableBackRouteStops = MutableStateFlow<List<ConcessionStop>>(emptyList())
    val availableRouteStops = _availableRouteStops.combine(uiState) { _, state ->
        val goVariants = state.busRoute?.variantsGo
        getAvailableRoutesFor(
            possibleVariants = goVariants,
            state = state
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())
    val availableBackRouteStops = _availableBackRouteStops.combine(uiState) { _, state ->
        val backwardVariants = state.busRoute?.variantsBack
        getAvailableRoutesFor(
            possibleVariants = backwardVariants,
            state = state
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    private fun getAvailableRoutesFor(possibleVariants: List<Variants>?, state: BusRouteUiState) = when {
        possibleVariants == null -> emptyList()
        state.selectedVariant == null -> {
            state.busRoute?.stops?.filter {
                it.variants.any { variantLetter ->
                    possibleVariants.map { defaultVariant -> defaultVariant.type }.contains(variantLetter)
                }
            } ?: emptyList()
        }

        else -> {
            state.busRoute?.stops?.filter {
                it.variants.contains(state.selectedVariant.type)
            } ?: emptyList()
        }
    }

    fun getTimetable(busIdNumber: BusIdNumber) {
        viewModelScope.launch {
            getBusRouteUseCase(busIdNumber = busIdNumber)
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
