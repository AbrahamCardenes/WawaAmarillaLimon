package com.abrahamcardenes.lpa_domain.models.travellers

data class TimetableInfo(
    val lineId: String,
    val node: String,
    val warning: String,
    val notes: String,
    val routes: List<RoutePaths>,
    val concessionStops: List<ConcessionStop>,
    val schedules: List<ConcessionSchedule>
)
