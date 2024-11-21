package com.indigo.gymapp.exercises.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.requestFocus
import com.indigo.gymapp.ui.number.Number

@Composable
fun AddExercise(
    newExerciseName: String,
    onExerciseNameChange: (String) -> Unit,
    addExerciseOnClick: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val lifecycleOwner = LocalLifecycleOwner.current

    requestFocus(focusRequester, lifecycleOwner)

    Column(
        verticalArrangement = Arrangement.spacedBy(space = Number.Context.Gap.medium)
    ) {
        TextField(
            value = newExerciseName,
            label = stringResource(R.string.exercise_name),
            onValueChange = onExerciseNameChange,
            modifier = Modifier.focusRequester(focusRequester)
        )
        Button(
            text = stringResource(R.string.add_exercise),
            onClick = addExerciseOnClick
        )
    }
}