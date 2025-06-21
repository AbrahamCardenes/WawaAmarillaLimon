package com.abrahamcardenes.lpa_presentation.wawaBalance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.BalanceDbUseCases
import com.abrahamcardenes.lpa_domain.useCases.travellers.GetBalanceUseCase
import com.abrahamcardenes.lpa_domain.useCases.travellers.RefreshBalanceCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class WawaBalanceViewModel @Inject constructor(
    private val refreshBalanceCardsUseCase: RefreshBalanceCardsUseCase,
    private val getBalanceUseCase: GetBalanceUseCase,
    private val balanceDbUseCases: BalanceDbUseCases,
    private val crashlyticsService: CrashlyticsService,
    private val dispatchers: DispatchersProvider
) : ViewModel() {

    private val _balanceUiState = MutableStateFlow(BalanceUiState())
    val balanceUiState = _balanceUiState.onStart {
        getCardsFromDb()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BalanceUiState())

    fun onCardNumberChange(value: String) {
        _balanceUiState.update {
            it.copy(cardNumber = value)
        }
    }

    fun getBalance() {
        viewModelScope.launch {
            if (_balanceUiState.value.cardNumber.isEmpty()) return@launch
            getBalanceUseCase(_balanceUiState.value.cardNumber)
                .onSuccess { wawaBalance ->
                    saveCard(wawaCard = wawaBalance)
                }
                .onError {
                    logErrorIfIsUnknown(it)
                    updateErrorState(true)
                }
        }
    }

    fun updateErrorState(value: Boolean) {
        _balanceUiState.update { state ->
            state.copy(errorHappened = value)
        }
    }

    private suspend fun logErrorIfIsUnknown(it: DataError) {
        if (it is DataError.Remote.UnknownError) {
            crashlyticsService.logException(it.error ?: Exception("Null exception in Data Error Unknown"))
        }
    }

    private fun saveCard(wawaCard: WawaCardBalance) {
        viewModelScope.launch(dispatchers.IO) {
            balanceDbUseCases.saveCard(wawaCard)
        }
    }

    fun removeCard(wawaCard: WawaCardBalance) {
        viewModelScope.launch {
            balanceDbUseCases.deleteCard(wawaCard)
        }
    }

    fun getCardsFromDb() {
        viewModelScope.launch {
            balanceDbUseCases.getAllCards().collect { cards ->
                _balanceUiState.update { state ->
                    state
                        .copy(
                            wawaCards = cards
                        )
                }
            }
        }
    }

    fun refreshCards() {
        viewModelScope.launch {
            _balanceUiState.update { state ->
                state.copy(isRefreshing = true)
            }
            _balanceUiState.update { state ->
                state
                    .copy(
                        wawaCards = refreshBalanceCardsUseCase(_balanceUiState.value.wawaCards),
                        isRefreshing = false
                    )
            }
        }
    }
}
