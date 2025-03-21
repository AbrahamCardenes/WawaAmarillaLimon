package com.abrahamcardenes.wawaamarillalimon.domain.models.travellers

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.ScheduleTime

data class ConcessionSchedule(
    val availableDays: String,
    val times: List<ScheduleTime>
)
