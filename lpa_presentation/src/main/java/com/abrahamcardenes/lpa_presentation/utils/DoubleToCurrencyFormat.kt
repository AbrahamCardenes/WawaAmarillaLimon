package com.abrahamcardenes.lpa_presentation.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Double.toLocalCurrency(locale: Locale = Locale.getDefault()): String {
    val symbols = DecimalFormatSymbols(locale)
    val decimalFormat = DecimalFormat("0.00", symbols)
    return decimalFormat.format(this)
}
