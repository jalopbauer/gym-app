package com.indigo.gymapp.exercises.local

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun Exercises(exercises: List<Exercise>, deleteOnClick: (Long) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = Context.Gap.default)
    ) {
        items(exercises) { exercise ->
            Exercise(
                exercise = exercise,
                deleteOnClick = deleteOnClick
            )
        }
    }
}