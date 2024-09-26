package com.indigo.gymapp.routines.exercises.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.SetExercise
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.routines.exercises.list.item.RoutineExerciseListItem
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun RoutineExerciseList(routineExercises: List<RoutineExercise>) {
    Column (
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default)
    ) {
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
}

@Preview
@Composable
private fun RoutineExerciseListPreview() {
    HugPreview {
        RoutineExerciseList(
            routineExercises = listOf(
                SetExercise("Chest press", 4, Rest(2, 0)),
                SetExercise("Incline press", 4, Rest(2, 0)),
                SetExercise("Bench dips", 3, Rest(2, 0)),
                SetExercise("Overhead triceps", 3, Rest(2, 0)),
            )
        )
    }
}