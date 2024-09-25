package com.indigo.gymapp.components.list.routineExercise

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.components.list.routineExercise.item.RoutineExerciseListItem
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise

@Composable
fun RoutineExerciseList(routineExercises: List<RoutineExercise>) {
    Title(
        title = stringResource(id = R.string.routine_exercises),
        textSize = Large
    )
    routineExercises.forEach {
        RoutineExerciseListItem(
            routineExercise = it
        )
    }
}