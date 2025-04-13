package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.lpa_domain.useCases.travellers.GetBalanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class WawaBalanceViewModel @Inject constructor(private val getBalanceUseCase: GetBalanceUseCase) : ViewModel() {

    private val _balanceUiState = MutableStateFlow(BalanceUiState())
    val balanceUiState = _balanceUiState.asStateFlow()

    fun onCardNumberChange(value: String) {
        _balanceUiState.update {
            it.copy(cardNumber = value)
        }
    }

    fun getBalance() {
        viewModelScope.launch {
            println(_balanceUiState.value.cardNumber)
            if (_balanceUiState.value.cardNumber.isEmpty()) return@launch
            getBalanceUseCase(_balanceUiState.value.cardNumber)
                .onSuccess { wawaBalance ->
                    _balanceUiState.update { state ->
                        val cardsToEdit = state.wawaCards.toMutableList()
                        cardsToEdit.add(0, wawaBalance)
                        val currentCardsToShow = (cardsToEdit).distinctBy { it.code }
                        state.copy(wawaCards = currentCardsToShow)
                    }
                }
                .onError {
                }
        }
    }
}
