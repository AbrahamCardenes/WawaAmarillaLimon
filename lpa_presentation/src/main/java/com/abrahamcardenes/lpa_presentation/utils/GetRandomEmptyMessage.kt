package com.abrahamcardenes.lpa_presentation.utils

import com.abrahamcardenes.lpa_presentation.R

fun getRandomEmptyCatMessage(): Int {
    val catMessages = listOf(
        R.string.cat_empty_1,
        R.string.cat_empty_2,
        R.string.cat_empty_3,
        R.string.cat_empty_4,
        R.string.cat_empty_5
    )
    return catMessages.random()
}
