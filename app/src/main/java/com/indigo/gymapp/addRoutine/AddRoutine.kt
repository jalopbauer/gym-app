package com.indigo.gymapp.addRoutine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.addRoutine.exercise.Exercise
import com.indigo.gymapp.addRoutine.exercise.SetExercise
import com.indigo.gymapp.addRoutine.exercise.TimedExercise
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun AddRoutine(
) {
    val onClick = { /*TODO*/ }
    val exercises = listOf(
        SetExercise("Chest", 4, Rest(2,0)),
        TimedExercise("Running", Duration(2,0)),
    )
    Column {
        CreateHeader(
            title = "Name your routine",
            isSelected = false
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Spacing.Context.Padding.screen
                ),
            verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default)
        ) {
            TimeAmountTextDrawerButton(
                leadingText = "Rest between exercises",
                minutes = 2,
                seconds = 0,
                onClick = onClick
            )
            Title(
                title = "Exercises",
                textSize = Large
            )
            exercises.forEach{
                Exercise(
                    exercise = it
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAddExerciseEmpty() {
    ScreenPreview {
        AddRoutine()
    }
}