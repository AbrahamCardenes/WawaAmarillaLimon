package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import com.abrahamcardenes.lpa_data.data.mappers.latitudeOrLongitudeToDouble
import com.abrahamcardenes.lpa_domain.models.core.GpsCoordinates
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RouteStopsDto(
    @field:Json(name = "number")
    val number: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "longitude")
    val longitude: String,
    @field:Json(name = "latitude")
    val latitude: String,
    @field:Json(name = "node")
    val node: String,
    @field:Json(name = "variants")
    val variants: List<String>
) {
    fun getGpsCoordinates(): GpsCoordinates? {
        val longitude = longitude.latitudeOrLongitudeToDouble()
        val latitude = latitude.latitudeOrLongitudeToDouble()

        if (longitude == null || latitude == null) return null
        return GpsCoordinates(
            longitude = longitude,
            latitude = latitude
        )
    }
}
