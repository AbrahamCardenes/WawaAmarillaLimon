package com.abrahamcardenes.lpa_domain.models.travellers

import com.abrahamcardenes.lpa_domain.valueObjects.ScheduleTime

data class ConcessionSchedule(
    val availableDays: String,
    val times: List<ScheduleTime>
)
