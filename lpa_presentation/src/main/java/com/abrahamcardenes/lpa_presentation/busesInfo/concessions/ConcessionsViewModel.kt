package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.useCases.concessions.GetConcessionsUseCase
import com.abrahamcardenes.lpa_presentation.utils.getRandomString
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
    private val getConcessionsUseCase: GetConcessionsUseCase,
    private val crashlyticsService: CrashlyticsService
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
                    logErrorIfIsUnknown(it)
                }
        }
    }

    fun updateConcessionState(concessionState: ConcessionState) {
        _concessionUiState.update {
            it.copy(concessionState = concessionState)
        }
    }

    private suspend fun logErrorIfIsUnknown(it: DataError) {
        if (it is DataError.Remote.UnknownError) {
            crashlyticsService.logException(it.error ?: Exception("Null exception in Data Error Unknown"))
        }
    }
}
