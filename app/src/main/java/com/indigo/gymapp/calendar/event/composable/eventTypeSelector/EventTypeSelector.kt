package com.indigo.gymapp.calendar.event.composable.eventTypeSelector

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.calendar.event.composable.eventTypeSelector.item.EventTypeItem
import com.indigo.gymapp.calendar.event.composable.eventTypeSelector.item.RoutineVariant
import com.indigo.gymapp.common.itemSelector.ItemSelector
import com.indigo.gymapp.common.preview.hug.HugPreview

@Composable
fun EventTypeItemSelector(
    setRoutineOnClick: () -> Unit
) {
    ItemSelector {
        EventTypeItem(
            eventTypeItemVariant = RoutineVariant,
            onClick = setRoutineOnClick
        )
    }
}

@Preview
@Composable
private fun SelectRoutineExerciseTypeMenuPreview() {
    HugPreview {
        EventTypeItemSelector(
            setRoutineOnClick = {}
        )
    }
}