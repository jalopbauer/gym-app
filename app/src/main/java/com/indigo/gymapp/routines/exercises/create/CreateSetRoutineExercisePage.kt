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
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.domain.time.Rest

@Composable
fun CreateSetRoutineExercise(
    selectExerciseOnClick : () -> Unit,
    rest: Rest,
    exercise: Exercise?,
    setRestTimeOnClick : () -> Unit

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
            amount = 4,
            onClick = {}
        )
    }
}


@Preview
@Composable
private fun PreviewAddSetWithExerciseSet() {
    ScreenPreview {
        CreateSetRoutineExercise(
            selectExerciseOnClick = {},
            Rest(2, 0),
            exercise = Exercise(
                id = 1,
                name = "Chest press"
            ),
            setRestTimeOnClick = {}
        )
    }
}

@Preview
@Composable
private fun PreviewAddSetWithoutExerciseSet() {
    ScreenPreview {
        CreateSetRoutineExercise(
            selectExerciseOnClick = {},
            Rest(2, 0),
            exercise = null,
            setRestTimeOnClick = {}
        )
    }
}