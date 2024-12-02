package com.indigo.gymapp.routines.exercises.composable.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.searchList.SearchList
import com.indigo.gymapp.exercises.entity.ExerciseEntity


@Composable
fun ExerciseSearch(
    exerciseName: String,
    exercises: List<ExerciseEntity>,
    onQueryChange: (String) -> Unit,
    getExerciseOnClick: (ExerciseEntity) -> Unit
) {
    SearchList(
        query = exerciseName,
        placeholder = stringResource(R.string.search_exercise),
        items = exercises,
        text = { exercise -> exercise.name},
        onQueryChange = onQueryChange,
        getItemOnClick = getExerciseOnClick
    )
}