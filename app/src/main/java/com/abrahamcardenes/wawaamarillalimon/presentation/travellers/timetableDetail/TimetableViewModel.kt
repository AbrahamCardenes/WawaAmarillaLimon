package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetTimetablesUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class TimetableViewModel @Inject constructor(
    private val getTimetableUseCase: GetTimetablesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TimetableUiState())
    val uiState = _uiState.asStateFlow()

    fun getTimetable(busIdNumber: BusIdNumber) {
        viewModelScope.launch {
            getTimetableUseCase(busIdNumber = busIdNumber)
                .onSuccess {
                    _uiState.update { state ->
                        state.copy(isLoading = false, timetableInfo = it)
                    }
                }
                .onError {
                    println(it.toString())
                }
        }
    }
}

data class TimetableUiState(
    val isLoading: Boolean = true,
    val timetableInfo: BusTimetables? = null
)
