package com.indigo.gymapp.calendar.event.composable.eventTypeSelector.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.Exercise
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.itemSelector.item.SelectorItem
import com.indigo.gymapp.common.preview.hug.HugPreview

@Composable
fun EventTypeItem(
    eventTypeItemVariant : EventTypeItemVariant,
    onClick: () -> Unit
) {
    SelectorItem(
        iconVariant = iconVariant(eventTypeItemVariant),
        header = headline(eventTypeItemVariant),
        body = body(eventTypeItemVariant),
        onClick = onClick
    )
}

@Composable
private fun iconVariant(eventTypeItemVariant: EventTypeItemVariant): IconVariant =
    when (eventTypeItemVariant) {
        RoutineVariant -> Exercise
    }

@Composable
fun headline(eventTypeItemVariant : EventTypeItemVariant) : String =
    stringResource(
        when (eventTypeItemVariant) {
            RoutineVariant -> R.string.routine
        }
    )

@Composable
fun body(eventTypeItemVariant : EventTypeItemVariant) : String =
    stringResource(
        when (eventTypeItemVariant) {
            RoutineVariant -> R.string.select_one_of_your_routines_to_repeat_weekly
        }
    )


sealed interface EventTypeItemVariant

data object RoutineVariant : EventTypeItemVariant

@Preview
@Composable
private fun RoutineVariantItemPreview() {
    HugPreview {
        EventTypeItem(
            eventTypeItemVariant = RoutineVariant,
            onClick = {}
        )
    }
}