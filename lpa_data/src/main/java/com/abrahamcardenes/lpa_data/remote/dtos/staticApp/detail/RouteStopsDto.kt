package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import com.abrahamcardenes.lpa_data.data.mappers.latitudeOrLongitudeToDouble
import com.abrahamcardenes.lpa_domain.models.common.GpsCoordinates
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RouteStopsDto(
    @SerialName(value = "number")
    val number: String,
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "longitude")
    val longitude: String,
    @SerialName(value = "latitude")
    val latitude: String,
    @SerialName(value = "node")
    val node: String,
    @SerialName(value = "variants")
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
