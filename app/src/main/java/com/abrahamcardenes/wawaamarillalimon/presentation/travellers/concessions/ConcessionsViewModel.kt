package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.concessions

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetConcessionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ConcessionsViewModel @Inject constructor(
    private val getConcessionsUseCase: GetConcessionsUseCase
) : ViewModel() {

    private val _concessionUiState = MutableStateFlow(ConcessionsUiState())
    val concessionUiState = _concessionUiState.onStart {
        getConcessions()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), ConcessionsUiState())

    private fun getConcessions() {
        _concessionUiState.update { state ->
            state.copy(isLoading = true)
        }
        viewModelScope.launch {
            getConcessionsUseCase()
                .onSuccess { concessions ->
                    _concessionUiState.update {
                        it.copy(concessions = concessions, isLoading = false)
                    }
                }
                .onError {
                    Log.e(
                        "TravellersException",
                        "Error al obtener los buses $it"
                    )
                }
        }
    }
}
