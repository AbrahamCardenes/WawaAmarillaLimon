package com.abrahamcardenes.lpa_presentation.utils

import java.text.Normalizer

fun String.removeNonSpacingMarks() = Normalizer
    .normalize(this, Normalizer.Form.NFD)
    .replace("\\p{Mn}+".toRegex(), "")
