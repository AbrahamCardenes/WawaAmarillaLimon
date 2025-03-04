package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetTimetablesUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusIdNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class TimetableViewModel @Inject constructor(
    private val getTimetableUseCase: GetTimetablesUseCase
) : ViewModel() {

    fun getTimetable(busIdNumber: BusIdNumber) {
        viewModelScope.launch {
            getTimetableUseCase(busIdNumber = busIdNumber)
                .onSuccess {
                    println(it.toString())
                }
                .onError {
                    println(it.toString())
                }
        }
    }
}
