package com.indigo.gymapp.routines.create.exercise.create

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
import com.indigo.gymapp.time.Rest

@Composable
fun CreateSetRoutineExercise(
    selectExerciseOnClick : () -> Unit,
    setRestTimeOnClick : () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        OnlyTextDrawerButton(
            leadingText = stringResource(id = R.string.select_exercise),
            onClick = selectExerciseOnClick
        )
        TimeAmountTextDrawerButton(
            leadingText = stringResource(id = R.string.rest_between_exercises),
            time = Rest(2, 0),
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
private fun PreviewAddSet() {
    ScreenPreview {
        CreateSetRoutineExercise(
            selectExerciseOnClick = {},
            setRestTimeOnClick = {}
        )
    }
}