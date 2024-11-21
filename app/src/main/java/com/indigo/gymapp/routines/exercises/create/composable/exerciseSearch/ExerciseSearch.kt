package com.indigo.gymapp.routines.exercises.create.composable.exerciseSearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.searchBar.SearchBar
import com.indigo.gymapp.exercises.entity.ExerciseEntity
import com.indigo.gymapp.routines.exercises.create.composable.exerciseTextButton.ExerciseTextButton
import com.indigo.gymapp.ui.number.Number.Context


@Composable
fun ExerciseSearch(
    exerciseName: String,
    exercises: List<ExerciseEntity>,
    onQueryChange: (String) -> Unit,
    getExerciseOnClick: (ExerciseEntity) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxHeight(0.5f),
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        SearchBar(
            query = exerciseName,
            onQueryChange = onQueryChange
        )
        LazyColumn {
            items(exercises) { exercise ->
                ExerciseTextButton(
                    exercise = exercise,
                    getExerciseOnClick = getExerciseOnClick
                )

            }
        }
    }
}