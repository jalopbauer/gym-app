package com.indigo.gymapp.routines.exercises.create.exerciseSearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.searchBar.SearchBar
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.routines.exercises.create.exerciseTextButton.ExerciseTextButton
import com.indigo.gymapp.ui.spacing.Spacing.Context


@Composable
fun ExerciseSearch(
    exerciseName: String,
    exercises: List<Exercise>,
    onQueryChange: (String) -> Unit,
    getExerciseOnClick: (Exercise) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxHeight(0.5f),
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        SearchBar(
            query = exerciseName,
            onQueryChange = onQueryChange
        )
        exercises.forEach { exercise ->
            ExerciseTextButton(
                exercise = exercise,
                getExerciseOnClick = getExerciseOnClick
            )
        }
    }
}