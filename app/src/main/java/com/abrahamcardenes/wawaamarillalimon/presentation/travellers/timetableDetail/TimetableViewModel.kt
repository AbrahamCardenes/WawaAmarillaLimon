package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetTimetablesUseCase
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
class TimetableViewModel @Inject constructor(
    private val getTimetableUseCase: GetTimetablesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TimetableUiState())
    val uiState = _uiState.asStateFlow()

    private val _filteredConcessions = MutableStateFlow<List<ConcessionStop>>(emptyList())
    val filteredConcessions = _filteredConcessions.combine(uiState) { _, state ->
        val selectedTimetable =
            state.timetableInfo?.timetables?.getOrNull(state.selectedIndex)
        when {
            selectedTimetable == null -> emptyList()
            state.selectedRoute == null -> selectedTimetable.concessionStops
            else -> selectedTimetable.concessionStops.filter { concessionStop ->
                concessionStop.type.contains(state.selectedRoute.type)
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    fun getTimetable(busIdNumber: BusIdNumber) {
        viewModelScope.launch {
            getTimetableUseCase(busIdNumber = busIdNumber)
                .onSuccess { timetableInfo ->
                    _uiState.update { state ->
                        state.copy(
                            isLoading = false,
                            timetableInfo = timetableInfo
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
                selectedRoute = null
            )
        }
    }

    fun onRouteSelection(routePaths: RoutePaths) {
        _uiState.update { state ->
            state.copy(selectedRoute = routePaths)
        }
    }
}
