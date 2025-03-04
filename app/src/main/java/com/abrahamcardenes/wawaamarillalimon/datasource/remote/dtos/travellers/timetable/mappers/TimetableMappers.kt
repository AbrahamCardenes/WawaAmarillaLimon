package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.mappers

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.BusTimetablesDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.ConcessionStopDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.RoutePathsDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.ScheduleDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable.TimetableDto
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionSchedule
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.TimetableInfo

fun BusTimetablesDto.toDomain(): BusTimetables = BusTimetables(
    timetables = timetables.map { it.toDomain() }
)

fun TimetableDto.toDomain(): TimetableInfo = TimetableInfo(
    lineId = this.lineId,
    node = this.node,
    warning = this.warning,
    notes = this.observations,
    routes = this.routes.map { routePathDto ->
        routePathDto.toDomain()
    },
    concessionStops = this.concessionStops.map { concessionStopDto ->
        concessionStopDto.toDomain()
    },
    schedules = this.schedules.map { schedulesDto ->
        schedulesDto.toDomain()
    }
)

fun RoutePathsDto.toDomain(): RoutePaths = RoutePaths(
    type = this.type,
    hexColor = this.hexColour,
    notes = this.observations
)

fun ConcessionStopDto.toDomain(): ConcessionStop = ConcessionStop(
    name = this.name,
    type = this.type
)

fun ScheduleDto.toDomain(): ConcessionSchedule = ConcessionSchedule(
    availableDays = this.availableDays,
    times = this.times
)
