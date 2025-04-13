package com.abrahamcardenes.lpa_data.data.mappers

fun String.latitudeOrLongitudeToDouble(): Double? = try {
    this.toDouble()
} catch (e: Exception) {
    null
}
