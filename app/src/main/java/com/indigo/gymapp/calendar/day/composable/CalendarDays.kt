package com.indigo.gymapp.calendar.day.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.calendar.day.CalendarDay
import com.indigo.gymapp.calendar.day.NotToday
import com.indigo.gymapp.calendar.day.Today
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun CalendarDays(
    calendarDays: List<CalendarDay>,
    onClick : (RoutineEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Gap.default),
    ) {
        items(calendarDays) { calendarDay ->
            CalendarDay(
                calendarDay = calendarDay,
                onClick = onClick
            )
        }
    }
}

@Preview
@Composable
private fun CalendarDayPreview() {
    ScreenPreview {
        CalendarDays(
            calendarDays = listOf(
                Today(
                    routineEvents = listOf(
                        RoutineEvent(
                            id = 0,
                            name = "Push",
                            estimatedDuration = Duration(
                                hours = 1,
                                minutes = 30
                            )
                        )
                    )
                ),
                NotToday(
                    dayOfTheWeek = Monday,
                    routineEvents = listOf(
                        RoutineEvent(
                            id = 0,
                            name = "Pull",
                            estimatedDuration = Duration(
                                hours = 2,
                                minutes = 0
                            )
                        )
                    )
                )
            ),
            onClick = { },
        )
    }
}