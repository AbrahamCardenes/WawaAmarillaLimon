package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

sealed class ConcessionState() {
    data object Loading : ConcessionState()
    data object Success : ConcessionState()
    data object Error : ConcessionState()
}
