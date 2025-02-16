package com.abrahamcardenes.wawaamarillalimon.presentation.travellers

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.LineDto
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetBusesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class TravellersViewModel @Inject constructor(
    private val getBusesUseCase: GetBusesUseCase
) : ViewModel() {

    private val _travellersState = MutableStateFlow(TravellersUiState())
    val travellersState = _travellersState.onStart {
        viewModelScope.launch {
            getBusesUseCase().onSuccess { buses ->
                _travellersState.update {
                    it.copy(buses = buses.response.concessions.lines)
                }
            }
                .onError {
                    Log.e(
                        "TravellersException",
                        "Error al obtener los buses $it"
                    )
                }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), TravellersUiState())
}

data class TravellersUiState(
    val buses: List<LineDto> = emptyList()
)
