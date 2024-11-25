package com.indigo.gymapp.routines.exercises.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.textButton.CenteredTextButton
import com.indigo.gymapp.common.button.textButton.TimeAmountTextButton
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.exercises.entity.ExerciseEntity

@Composable
fun CreateTimedRoutineExercise(
    exercise: ExerciseEntity?,
    selectExerciseOnClick : () -> Unit
) {
    val onClick = { /*TODO*/ }
    val exerciseText = exercise?.name ?: stringResource(id = R.string.select_exercise)
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenteredTextButton(
            text = exerciseText,
            selected = exercise != null,
            onClick = selectExerciseOnClick
        )
        TimeAmountTextButton(
            text = stringResource(id = R.string.duration),
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
            exercise = null,
            selectExerciseOnClick = {}
        )
    }
}