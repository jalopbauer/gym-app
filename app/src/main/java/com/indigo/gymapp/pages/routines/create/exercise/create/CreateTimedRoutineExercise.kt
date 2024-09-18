package com.indigo.gymapp.pages.routines.create.exercise.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.textInput.OnlyTextDrawerButton
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.domain.time.Duration

@Composable
fun CreateTimedRoutineExercise(
    selectExerciseOnClick : () -> Unit
) {
    val onClick = { /*TODO*/ }
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        OnlyTextDrawerButton(
            leadingText = stringResource(id = R.string.select_exercise),
            onClick = selectExerciseOnClick
        )
        TimeAmountTextDrawerButton(
            leadingText = stringResource(id = R.string.duration),
            time = Duration(30, 0),
            onClick = onClick,
        )
    }
}


@Preview
@Composable
private fun PreviewAddSet() {
    ScreenPreview {
        CreateTimedRoutineExercise(
            selectExerciseOnClick = {}
        )
    }
}