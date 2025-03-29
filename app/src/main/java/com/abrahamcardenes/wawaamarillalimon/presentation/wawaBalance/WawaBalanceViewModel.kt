package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetBalanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class WawaBalanceViewModel @Inject constructor(private val getBalanceUseCase: GetBalanceUseCase) : ViewModel() {

    private val _balanceUiState = MutableStateFlow(BalanceUiState())
    val balanceUiState = _balanceUiState.asStateFlow()

    init {
        // imTooLazyToTestThisManually()
    }

    fun onCardNumberChange(value: String) {
        _balanceUiState.update {
            if (!value.isDigitsOnly()) return@update it
            it.copy(cardNumber = value)
        }
    }

    fun getBalance() {
        viewModelScope.launch {
            getBalanceUseCase(_balanceUiState.value.cardNumber)
                .onSuccess { wawaBalance ->
                    _balanceUiState.update { state ->
                        val auxList = state.wawaCards.toMutableList()
                        auxList.add(0, wawaBalance)
                        val cards = (auxList).distinctBy { it.code }
                        state.copy(wawaCards = cards)
                    }
                }
                .onError {
                }
        }
    }

    private fun imTooLazyToTestThisManually() {
        viewModelScope.launch {
            var initialCarNumber = 579990
            repeat(10) {
                launch {
                    onCardNumberChange(initialCarNumber.toString())
                    getBalance()
                    initialCarNumber++
                    delay(2.seconds)
                }.join()
            }
        }
    }
}
