package com.abrahamcardenes.lpa_presentation.utils

import com.abrahamcardenes.lpa_presentation.R

fun getRandomString(): Int {
    val catMessages = listOf(
        R.string.cat_error_1,
        R.string.cat_error_2,
        R.string.cat_error_3,
        R.string.cat_error_4,
        R.string.cat_error_5
    )
    return catMessages.random()
}
