package com.indigo.gymapp.calendar.day

import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek

sealed interface CalendarDay {
    val routineEvents: List<RoutineEvent>
}

data class Today(override val routineEvents: List<RoutineEvent>): CalendarDay

data class NotToday(val dayOfTheWeek: DayOfTheWeek, override val routineEvents: List<RoutineEvent>): CalendarDay
