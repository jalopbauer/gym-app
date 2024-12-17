package com.indigo.gymapp.calendar.event.routine.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun RoutineEvents(
    routineEvents: List<RoutineEvent>,
    isToday : Boolean,
    onClick : (RoutineEvent) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        routineEvents.forEach { routineEvent ->
            RoutineEvent(
                isToday = isToday,
                event = routineEvent,
                onClick = onClick
            )
        }

    }
}