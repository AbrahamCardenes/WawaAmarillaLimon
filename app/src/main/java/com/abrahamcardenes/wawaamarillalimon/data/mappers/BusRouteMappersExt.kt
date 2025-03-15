package com.abrahamcardenes.wawaamarillalimon.data.mappers

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes.BusRouteDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes.RouteStopsDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes.VariantsDto
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.toRGBAColor

fun BusRouteDto.toDomain(): BusRoute = BusRoute(
    line = line,
    name = name,
    color = color.toRGBAColor(),
    nodes = nodes,
    variantsGo = variantsGo.toVariantsDomain(),
    variantsBack = variantsBack.toVariantsDomain(),
    stops = stops.toStopsDomain()
)

fun List<VariantsDto>.toVariantsDomain(): List<Variants> = this.map { variantDto ->
    Variants(
        type = variantDto.type,
        name = variantDto.name,
        color = variantDto.color.toRGBAColor()
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
