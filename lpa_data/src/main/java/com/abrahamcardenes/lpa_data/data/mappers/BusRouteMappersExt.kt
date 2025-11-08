package com.abrahamcardenes.lpa_data.data.mappers

import com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail.BusRouteDto
import com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail.RouteStopsDto
import com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail.ScheduleStaticaDto
import com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail.VariantsDto
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusSchedule
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_domain.valueObjects.toRgba

fun BusRouteDto.toDomain(): BusRoute = BusRoute(
    line = line,
    name = name,
    color = color.toRgba(),
    nodes = nodes,
    variantsGo = variantsGo.toVariantsDomain(),
    variantsBack = variantsBack.toVariantsDomain(),
    stops = stops.toStopsDomain(),
    schedules = schedule.map { it.toDomain() }
)

fun List<VariantsDto>.toVariantsDomain(): List<Variants> = this.map { variantDto ->
    Variants(
        type = variantDto.type,
        name = variantDto.name,
        color = variantDto.color.toRgba()
    )
}

fun List<RouteStopsDto>.toStopsDomain(): List<RouteStop> = this.map { routeStopDto ->
    RouteStop(
        number = routeStopDto.number,
        name = routeStopDto.name,
        gpsCoordinates = routeStopDto.getGpsCoordinates(),
        variants = routeStopDto.variants.map { it },
        node = routeStopDto.node
    )
}

fun ScheduleStaticaDto.toDomain(): BusSchedule = BusSchedule(
    node = node,
    typology = tipology,
    time = time,
    color = color.toRgba(),
    variantLetter = variant
)
