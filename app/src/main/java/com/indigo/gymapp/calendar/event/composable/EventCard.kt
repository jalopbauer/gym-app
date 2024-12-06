package com.indigo.gymapp.calendar.event.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.common.button.textButton.DeleteTextButton
import com.indigo.gymapp.common.card.Card
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.Friday
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.Saturday
import com.indigo.gymapp.common.daysOfTheWeek.Sunday
import com.indigo.gymapp.common.daysOfTheWeek.Thursday
import com.indigo.gymapp.common.daysOfTheWeek.Tuesday
import com.indigo.gymapp.common.daysOfTheWeek.Wednesday
import com.indigo.gymapp.common.daysOfTheWeek.descriptor.DaysOfTheWeekDescriptor
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.ui.number.Number.Component.Card.Event
import com.indigo.gymapp.time.Rest

@Composable
fun EventCard(
    routineEvent: RoutineEvent,
    sundayFirstDay: Boolean,
    deleteEventOnClick: (RoutineEvent) -> Unit,
    editEventOnClick: (RoutineEvent) -> Unit
) {
    val isDaySelected: (DayOfTheWeek) -> Boolean = { dayOfTheWeek ->
        routineEvent.daysOfTheWeek.contains(dayOfTheWeek)
    }
    Card(
        onClick = { editEventOnClick(routineEvent) }
    ) {
        DeleteTextButton(
            text = routineEvent.name,
            onClick = { deleteEventOnClick(routineEvent) }
        )
        Row(
            modifier = Modifier
                .padding(PaddingValues(bottom = Event.bottomPadding)),
        ){
            DaysOfTheWeekDescriptor(
                monday = isDaySelected(Monday),
                tuesday = isDaySelected(Tuesday),
                wednesday = isDaySelected(Wednesday),
                thursday = isDaySelected(Thursday),
                friday = isDaySelected(Friday),
                saturday = isDaySelected(Saturday),
                sunday = isDaySelected(Sunday),
                sundayFirstDay = sundayFirstDay
            )
        }
    }
}

@Preview
@Composable
private fun AllDaysEventCard() {
    HugPreview{
        EventCard(
            routineEvent = RoutineEvent(
                name = "Push",
                estimatedDuration = Rest(hours = 1, minutes = 30),
                daysOfTheWeek = setOf(
                    Monday,
                    Tuesday,
                    Wednesday,
                    Thursday,
                    Friday,
                    Saturday,
                    Sunday
                )
            ),
            sundayFirstDay = true,
            deleteEventOnClick = { },
            editEventOnClick = { },
        )
    }
}

@Preview
@Composable
private fun OneDayEventCard() {
    HugPreview{
        EventCard(
            routineEvent = RoutineEvent(
                name = "Push",
                estimatedDuration = Rest(hours = 1, minutes = 30),
                daysOfTheWeek = setOf(
                    Monday,
                )
            ),
            sundayFirstDay = true,
            deleteEventOnClick = { },
            editEventOnClick = { },
        )
    }
}