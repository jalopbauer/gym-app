package com.indigo.gymapp.routines.create.exercise.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun CreateRoutineExercise(
    onNavigateToCreateRoutine : () -> Unit,
    addExerciseVariant : AddExerciseVariant = Empty
) {
    val title = stringResource(id = getTitle(addExerciseVariant))
    val isSelected = getIsSelected(addExerciseVariant)
    Column {
        CreateHeader(
            title = title,
            isSelected = isSelected,
            onClickDrawerButton = {},
            onClickSave = {
                onNavigateToCreateRoutine()
            },
            onClickCancel = {
                onNavigateToCreateRoutine()
            },
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Spacing.Context.Padding.screen
                )
        ) {
            when (addExerciseVariant) {
                CreateSetRoutineExercise -> CreateSetRoutineExercise()
                CreateTimedRoutineExercise -> CreateTimedRoutineExercise()
                Empty -> {}
            }
        }
    }
}

private fun getIsSelected(addExerciseVariant: AddExerciseVariant) =
    when (addExerciseVariant) {
        CreateSetRoutineExercise -> true
        CreateTimedRoutineExercise -> true
        Empty -> false
    }

private fun getTitle(addExerciseVariant: AddExerciseVariant) =
    when (addExerciseVariant) {
        CreateSetRoutineExercise -> R.string.set
        CreateTimedRoutineExercise -> R.string.timed
        Empty -> R.string.select_exercise_type
    }

@Preview
@Composable
private fun PreviewAddExerciseEmpty() {
    ScreenPreview {
        CreateRoutineExercise(
            onNavigateToCreateRoutine = {}
        )
    }
}

@Preview
@Composable
private fun PreviewAddESet() {
    ScreenPreview {
        CreateRoutineExercise(
            onNavigateToCreateRoutine = {},
            addExerciseVariant = CreateSetRoutineExercise
        )
    }
}

@Preview
@Composable
private fun PreviewAddTimed() {
    ScreenPreview {
        CreateRoutineExercise(
            onNavigateToCreateRoutine = {},
            addExerciseVariant = CreateTimedRoutineExercise
        )
    }
}

sealed interface AddExerciseVariant
data object CreateSetRoutineExercise : AddExerciseVariant
data object CreateTimedRoutineExercise : AddExerciseVariant
data object Empty : AddExerciseVariant