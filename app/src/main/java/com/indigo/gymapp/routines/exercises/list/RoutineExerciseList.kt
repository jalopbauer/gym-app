package com.indigo.gymapp.routines.exercises.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.indigo.gymapp.exercises.ExerciseEntity
import com.indigo.gymapp.routines.exercises.list.item.RoutineExerciseListItem
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun RoutineExerciseList(
    routineExercises: List<RoutineExercise>,
    selectedRoutineExerciseId: Long?,
    selectOnClick: (Long) -> Unit
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default)
    ) {
        Title(
            title = stringResource(id = R.string.routine_exercises),
            textSize = Large
        )
        LazyColumn {
            items(routineExercises) { exercise ->
                RoutineExerciseListItem(
                    routineExercise = exercise,
                    selectedRoutineExerciseId = selectedRoutineExerciseId,
                    selectOnClick = selectOnClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun RoutineExerciseListPreview() {
    HugPreview {
        RoutineExerciseList(
            routineExercises = listOf(
                SetExercise(id = 0, exercise = ExerciseEntity(name = "Chest press"), amountOfSets = 4, rest = Rest(2, 0)),
                SetExercise(id = 1, exercise = ExerciseEntity(name = "Incline press"), amountOfSets = 4, rest = Rest(2, 0)),
                SetExercise(id = 2, exercise = ExerciseEntity(name = "Bench dips"), amountOfSets = 3, rest = Rest(2, 0)),
                SetExercise(id = 3, exercise = ExerciseEntity(name = "Overhead triceps"), amountOfSets = 3, rest = Rest(2, 0)),
            ),
            selectedRoutineExerciseId = 2,
            selectOnClick = {}
        )
    }
}