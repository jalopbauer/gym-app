package com.indigo.gymapp.calendar.day.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.calendar.day.CalendarDay
import com.indigo.gymapp.calendar.day.NotToday
import com.indigo.gymapp.calendar.day.Today
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.calendar.event.composable.EmptyEvent
import com.indigo.gymapp.calendar.event.routine.composable.RoutineEvents
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.getDayFullName
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun CalendarDay(
    calendarDay: CalendarDay,
    onClick : (RoutineEvent) -> Unit
) {
    val title = when (calendarDay) {
        is NotToday -> getDayFullName(calendarDay.dayOfTheWeek)
        is Today -> stringResource(R.string.today)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        Title(
            title = title,
            textSize = Large

        )
        val routineEvents = calendarDay.routineEvents
        if (routineEvents.isNotEmpty()) {
            RoutineEvents(
                routineEvents = routineEvents,
                isToday = calendarDay is Today,
                onClick = onClick
            )
        } else {
            EmptyEvent(
                text = title
            )
        }
    }
}

@Preview
@Composable
private fun EmptyToday() {
    HugPreview {
        CalendarDay(
            calendarDay = Today(
                routineEvents = emptyList()
            ),
            onClick = { },
        )
    }
}

@Preview
@Composable
private fun EmptyMonday() {
    HugPreview {
        CalendarDay(
            calendarDay = NotToday(
                dayOfTheWeek = Monday,
                routineEvents = emptyList()
            ),
            onClick = { },
        )
    }
}

@Preview
@Composable
private fun NotEmptyToday() {
    HugPreview {
        CalendarDay(
            calendarDay = Today(
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
            onClick = { },
        )
    }
}

@Preview
@Composable
private fun NotEmptyMonday() {
    HugPreview {
        CalendarDay(
            calendarDay = NotToday(
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
            ),
            onClick = { },
        )
    }
}