package com.indigo.gymapp.calendar.event.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun Events(
    routineEvents: List<RoutineEvent>,
    sundayFirstDay: Boolean,
    deleteEventOnClick: (RoutineEvent) -> Unit,
    editEventOnClick: (RoutineEvent) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        items(routineEvents) { routineEvent ->
            EventCard(
                routineEvent = routineEvent,
                sundayFirstDay = sundayFirstDay,
                deleteEventOnClick = deleteEventOnClick,
                editEventOnClick = editEventOnClick
            )
        }

    }
}