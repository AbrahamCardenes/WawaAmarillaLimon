package com.abrahamcardenes.wawaamarillalimon.fakes

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.Variants

fun busRouteFake(): BusRoute = BusRoute(
    line = "50",
    name = "Ciudad Deportiva Gran Canaria - Zárate",
    color = RGBAColor(
        red = 185,
        green = 102,
        blue = 161,
        alpha = 1
    ),
    nodes = listOf(
        "Ciudad Deportiva Gran Canaria",
        "Zárate"
    ),
    variantsGo = listOf(
        Variants(
            type = "A",
            name = "Ciudad Deportiva Gran Canaria - Zárate",
            color = RGBAColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1
            )
        )
    ),
    variantsBack = listOf(
        Variants(
            type = "B",
            name = "Zárate - Ciudad Deportiva Gran Canaria",
            color = RGBAColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1
            )
        ),
        Variants(
            type = "D",
            name = "Estas expediciones no circulan por Francisco Inglott Artiles",
            color = RGBAColor(
                red = 231,
                green = 157,
                blue = 214,
                alpha = 1
            )
        )
    ),
    stops = listOf(
        RouteStop(
            number = "445",
            name = "Ciudad Deportiva Gran Canaria",
            gpsCoordinates = GpsCoordinates(
                longitude = -15.41727242,
                latitude = 28.07690029
            ),
            node = "Ciudad Deportiva Gran Canaria",
            variants = listOf("A")
        ),
        RouteStop(
            number = "970",
            name = "Leonardo Torriani (Zárate)",
            gpsCoordinates = GpsCoordinates(
                longitude = -15.42227448,
                latitude = 28.07906443
            ),
            node = "Zárate",
            variants = listOf("B", "D")
        ),

        RouteStop(
            number = "152",
            name = "Francisco Inglott Artiles, 33",
            gpsCoordinates = GpsCoordinates(
                longitude = -15.42022347,
                latitude = 28.08047426
            ),
            node = "Zárate",
            variants = listOf("B")
        )
    ),
    schedules = emptyList()
)

fun goStopsTypeA(): List<RouteStop> = listOf(
    RouteStop(
        number = "445",
        name = "Ciudad Deportiva Gran Canaria",
        gpsCoordinates = GpsCoordinates(
            longitude = -15.41727242,
            latitude = 28.07690029
        ),
        node = "Ciudad Deportiva Gran Canaria",
        variants = listOf("A")
    )
)

fun backStopsTypeBD(): List<RouteStop> = listOf(
    RouteStop(
        number = "970",
        name = "Leonardo Torriani (Zárate)",
        gpsCoordinates = GpsCoordinates(
            longitude = -15.42227448,
            latitude = 28.07906443
        ),
        node = "Zárate",
        variants = listOf("B", "D")
    ),
    RouteStop(
        number = "152",
        name = "Francisco Inglott Artiles, 33",
        gpsCoordinates = GpsCoordinates(
            longitude = -15.42022347,
            latitude = 28.08047426
        ),
        node = "Zárate",
        variants = listOf("B")
    )
)
