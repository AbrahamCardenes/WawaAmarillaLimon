package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetBalanceUseCase
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

    fun loadingStatusTo(value: Boolean) {
        _balanceUiState.update {
            it.copy(isLoading = value)
        }
    }

    fun getBalance() {
        loadingStatusTo(value = true)
        viewModelScope.launch {
            getBalanceUseCase(_balanceUiState.value.cardNumber)
                .onSuccess { wawaBalance ->
                    _balanceUiState.update {
                        it.copy(wawaCardBalance = wawaBalance, isLoading = false)
                    }
                }
                .onError {
                    loadingStatusTo(value = false)
                }
        }
    }
}

data class BalanceUiState(
    val cardNumber: String = "",
    val wawaCardBalance: WawaCardBalance? = null,
    val isLoading: Boolean = false
)
