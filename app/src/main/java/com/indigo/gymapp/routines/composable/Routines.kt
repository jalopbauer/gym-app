package com.indigo.gymapp.routines.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.routines.entity.RoutineEntity
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun Routines(
    routines: List<RoutineEntity>,
    onCardClick: (Long) -> Unit,
    onDeleteClick: (Long) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(space = Gap.default)
    ) {
        items(routines) { routine ->
            RoutineCard(
                routine = routine,
                onCardClick = onCardClick,
                onDeleteClick = onDeleteClick
            )
        }
    }
}