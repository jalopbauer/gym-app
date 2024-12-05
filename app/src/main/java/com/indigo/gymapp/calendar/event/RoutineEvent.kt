package com.indigo.gymapp.calendar.event

import com.indigo.gymapp.time.Duration

data class RoutineEvent(
    val id: Long,
    val name: String,
    val estimatedDuration : Duration
)