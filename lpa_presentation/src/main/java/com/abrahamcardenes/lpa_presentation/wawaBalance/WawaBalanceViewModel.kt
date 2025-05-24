package com.abrahamcardenes.lpa_presentation.wawaBalance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onError
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.BalanceDbUseCases
import com.abrahamcardenes.lpa_domain.useCases.travellers.GetBalanceUseCase
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
    private val getBalanceUseCase: GetBalanceUseCase,
    private val balanceDbUseCases: BalanceDbUseCases,
    private val crashlyticsService: CrashlyticsService
) : ViewModel() {

    private val _balanceUiState = MutableStateFlow(BalanceUiState())
    val balanceUiState = _balanceUiState.onStart {
        getAllCards()
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
                    _balanceUiState.update { state ->
                        val cardsToEdit = state.wawaCards.toMutableList()
                        cardsToEdit.add(0, wawaBalance)
                        val currentCardsToShow = (cardsToEdit).distinctBy { it.code }
                        state.copy(wawaCards = currentCardsToShow)
                    }
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
        viewModelScope.launch {
            balanceDbUseCases.saveCard(wawaCard)
        }
    }

    fun removeCard(wawaCard: WawaCardBalance) {
        viewModelScope.launch {
            balanceDbUseCases.deleteCard(wawaCard)
        }
    }

    fun getAllCards() {
        viewModelScope.launch {
            balanceDbUseCases.getAllCards().collect {
                val cardsThatICanShow = mutableListOf<WawaCardBalance>()
                val successfulCards = it.filter { cardResult ->
                    cardResult is Result.Success
                }

                val errorCards = it.filter { cardResult ->
                    cardResult is Result.Error
                }

                successfulCards.forEach { cardResult ->
                    cardResult.onSuccess { card -> cardsThatICanShow.add(card) }
                }

                errorCards.forEach { errorCard ->
                    errorCard.onError { error ->
                        logErrorIfIsUnknown(error)
                    }
                }

                _balanceUiState.update { state ->
                    state.copy(wawaCards = cardsThatICanShow)
                }
            }
        }
    }
}
