package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.lpa_domain.useCases.concessions.GetConcessionsUseCase
import com.abrahamcardenes.lpa_presentation.utils.getRandomString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class ConcessionsViewModel @Inject constructor(
    private val getConcessionsUseCase: GetConcessionsUseCase
) : ViewModel() {

    private val _concessionUiState = MutableStateFlow(ConcessionsUiState())
    val concessionUiState = _concessionUiState.onStart {
        getConcessions()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), ConcessionsUiState())

    fun getConcessions() {
        updateConcessionState(ConcessionState.Loading)
        viewModelScope.launch {
            getConcessionsUseCase()
                .onSuccess { concessions ->
                    _concessionUiState.update {
                        it.copy(concessions = concessions)
                    }
                    updateConcessionState(ConcessionState.Success)
                }
                .onError {
                    _concessionUiState.update { state ->
                        state.copy(errorMessage = getRandomString())
                    }
                    updateConcessionState(ConcessionState.Error)
                }
        }
    }

    fun updateConcessionState(concessionState: ConcessionState) {
        _concessionUiState.update {
            it.copy(concessionState = concessionState)
        }
    }
}
