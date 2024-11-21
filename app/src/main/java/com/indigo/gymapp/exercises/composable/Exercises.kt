package com.indigo.gymapp.exercises.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.spacer.ListBottomSpacer
import com.indigo.gymapp.exercises.entity.ExerciseEntity
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun Exercises(exercises: List<ExerciseEntity>, deleteOnClick: (Long) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = Gap.default)
    ) {
        items(exercises) { exercise ->
            Exercise(
                exercise = exercise,
                deleteOnClick = deleteOnClick
            )
        }
        item {
            ListBottomSpacer()
        }
    }
}

