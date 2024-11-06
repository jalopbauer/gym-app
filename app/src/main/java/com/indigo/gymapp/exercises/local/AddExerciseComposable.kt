package com.indigo.gymapp.exercises.local

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.textField.TextField

@Composable
fun AddExercise(
    newExerciseName: String,
    onExerciseNameChange: (String) -> Unit,
    addExerciseOnClick: () -> Unit
) {
    TextField(
        value = newExerciseName,
        label = stringResource(R.string.exercise_name),
        onValueChange = onExerciseNameChange
    )
    Button(
        text = stringResource(R.string.add_exercise),
        onClick = addExerciseOnClick
    )
}