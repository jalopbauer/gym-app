package com.indigo.gymapp.calendar.event.routine.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.common.button.iconButton.IconButton
import com.indigo.gymapp.common.icon.RightArrow
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.sidebar.Sidebar
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.time.displayDuration
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun RoutineEvent(isToday : Boolean, event: RoutineEvent, onClick : (RoutineEvent) -> Unit) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Gap.default)
        ) {
            Sidebar(
                selected = isToday
            )
            Column (
                verticalArrangement = Arrangement.spacedBy(Gap.default)
            ) {
                Title(
                    title = event.name,
                    textSize = Medium
                )
                IconTextValue(
                    iconVariant = TimedRoutineExercise,
                    label = "Estimated duration",
                    value = event.estimatedDuration.displayDuration()
                )
            }
        }
        IconButton(
            iconVariant = RightArrow,
            tint = if(isToday) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onPrimary,
            onClick = { onClick(event) },
        )
    }
}

@Preview
@Composable
private fun TodayRoutineEvent() {
    HugPreview {
        RoutineEvent(
            isToday = true,
            event = RoutineEvent(
                id = 0,
                name = "Push",
                estimatedDuration = Duration(hours = 1, minutes = 30)
            ),
            onClick =  { }
        )
    }
}

@Preview
@Composable
private fun NotTodayRoutineEvent() {
    HugPreview {
        RoutineEvent(
            isToday = false,
            event = RoutineEvent(
                id = 0,
                name = "Pull",
                estimatedDuration = Duration(hours = 2, minutes = 0)
            ),
            onClick =  { }
        )
    }
}