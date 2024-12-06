package com.indigo.gymapp.routines.composable

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.button.textButton.DeleteTextButton
import com.indigo.gymapp.common.card.Card
import com.indigo.gymapp.routines.entity.RoutineEntity

@Composable
fun RoutineCard(
    routine: RoutineEntity,
    onCardClick: (Long) -> Unit,
    onDeleteClick: (Long) -> Unit,
) {
    Card(
        onClick = { onCardClick(routine.id) }
    ) {
        DeleteTextButton(
            text = routine.name,
            onClick = { onDeleteClick(routine.id) }
        )
    }
}