package com.abrahamcardenes.lpa_domain.fakes

import com.abrahamcardenes.lpa_domain.models.common.GpsCoordinates
import com.abrahamcardenes.lpa_domain.models.common.WawaColor
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusSchedule
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants

fun busRouteFake(): BusRoute = BusRoute(
    line = "50",
    name = "Ciudad Deportiva Gran Canaria - Zárate",
    color = WawaColor(
        red = 185,
        green = 102,
        blue = 161,
        alpha = 1f
    ),
    nodes = listOf(
        "Ciudad Deportiva Gran Canaria",
        "Zárate"
    ),
    variantsGo = listOf(
        Variants(
            type = "A",
            name = "Ciudad Deportiva Gran Canaria - Zárate",
            color = WawaColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1f
            )
        )
    ),
    variantsBack = listOf(
        Variants(
            type = "B",
            name = "Zárate - Ciudad Deportiva Gran Canaria",
            color = WawaColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1f
            )
        ),
        Variants(
            type = "D",
            name = "Estas expediciones no circulan por Francisco Inglott Artiles",
            color = WawaColor(
                red = 231,
                green = 157,
                blue = 214,
                alpha = 1f
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
    schedules = schedulesFake()
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

fun schedulesFake(): List<BusSchedule> = listOf(
    BusSchedule(
        node = "Ciudad Deportiva Gran Canaria",
        typology = "De lunes a viernes",
        time = "06:55",
        color = WawaColor(
            red = 245,
            green = 245,
            blue = 245,
            alpha = 1f
        )
    ),
    BusSchedule(
        node = "Ciudad Deportiva Gran Canaria",
        typology = "De lunes a viernes",
        time = "7:30",
        color = WawaColor(
            red = 0,
            green = 0,
            blue = 0,
            alpha = 1f
        )
    ),
    BusSchedule(
        node = "Ciudad Deportiva Gran Canaria",
        typology = "Sábado",
        time = "08:05",
        color = WawaColor(
            red = 0,
            green = 0,
            blue = 0,
            alpha = 0f
        )
    ),
    BusSchedule(
        node = "Ciudad Deportiva Gran Canaria",
        typology = "Domingo y festivo",
        time = "07:50",
        color = WawaColor(
            red = 245,
            green = 245,
            blue = 245,
            alpha = 1f
        )
    ),

    BusSchedule(
        node = "Zárate",
        typology = "De lunes a viernes",
        time = "06:10",
        color = WawaColor(
            red = 245,
            green = 245,
            blue = 245,
            alpha = 1f
        )
    ),
    BusSchedule(
        node = "Zárate",
        typology = "Sábado",
        time = "07:10",
        color = WawaColor(
            red = 245,
            green = 245,
            blue = 245,
            alpha = 1f
        ),
        variantLetter = "D"
    ),
    BusSchedule(
        node = "Zárate",
        typology = "Domingo y festivo",
        time = "08:35",
        color = WawaColor(
            red = 231,
            green = 157,
            blue = 214,
            alpha = 1f
        ),
        variantLetter = "D"
    ),
    BusSchedule(
        node = "Zárate",
        typology = "Domingo y festivo",
        time = "10:20",
        color = WawaColor(
            red = 0,
            green = 0,
            blue = 0,
            alpha = 0f
        )
    )

)
