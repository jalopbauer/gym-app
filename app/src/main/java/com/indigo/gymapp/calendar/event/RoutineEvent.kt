package com.indigo.gymapp.calendar.event

import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.time.Duration

data class RoutineEvent(
    val id: Long = 0,
    val name: String,
    val estimatedDuration : Duration,
    val daysOfTheWeek: Set<DayOfTheWeek> = emptySet()
)