package com.indigo.gymapp.routines.exercises.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.textInput.IntAmountTextDrawerButton
import com.indigo.gymapp.common.button.textInput.OnlyTextDrawerButton
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.entity.ExerciseEntity

@Composable
fun CreateSetRoutineExercise(
    selectExerciseOnClick : () -> Unit,
    exercise: ExerciseEntity?,
    rest: Rest,
    amountOfSets: Int,
    setRestTimeOnClick: () -> Unit,
    setAmountOfSetsOnClick: () -> Unit,

    ) {
    val exerciseText = exercise?.name ?: stringResource(id = R.string.select_exercise)
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        OnlyTextDrawerButton(
            leadingText = exerciseText,
            isSelected = exercise != null,
            onClick = selectExerciseOnClick
        )
        TimeAmountTextDrawerButton(
            leadingText = stringResource(id = R.string.rest_between_exercises),
            time = rest,
            onClick = setRestTimeOnClick
        )
        IntAmountTextDrawerButton(
            leadingText = stringResource(id = R.string.amount_of_sets),
            amount = amountOfSets,
            onClick = setAmountOfSetsOnClick
        )
    }
}


@Preview
@Composable
private fun PreviewAddSetWithExerciseSet() {
    ScreenPreview {
        CreateSetRoutineExercise(
            selectExerciseOnClick = {},
            exercise = ExerciseEntity(
                id = 1,
                name = "Chest press"
            ),
            Rest(2, 0),
            amountOfSets = 4,
            setRestTimeOnClick = {},
            setAmountOfSetsOnClick = {}
        )
    }
}

@Preview
@Composable
private fun PreviewAddSetWithoutExerciseSet() {
    ScreenPreview {
        CreateSetRoutineExercise(
            selectExerciseOnClick = {},
            exercise = null,
            Rest(2, 0),
            amountOfSets = 4,
            setRestTimeOnClick = {},
            setAmountOfSetsOnClick = {}
        )
    }
}