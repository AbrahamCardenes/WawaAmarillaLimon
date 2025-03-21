package com.abrahamcardenes.wawaamarillalimon.data.mappers

fun String.latitudeOrLongitudeToDouble(): Double? = try {
    this.toDouble()
} catch (e: Exception) {
    null
}
