package com.indigo.gymapp.exercises.local

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun LocalExercises() {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()
    val exercises by exerciseViewModel.exercises.collectAsState(initial = emptyList())
    var newExerciseName by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        TextField(
            value = newExerciseName,
            label = stringResource(R.string.exercise_name),
            onValueChange = { newExerciseName = it }
        )
        Button(
            text = stringResource(R.string.add_exercise),
            onClick = {
                exerciseViewModel.createExercise(newExerciseName)
                Toast.makeText(context, context.getString(R.string.exercise_added, newExerciseName), Toast.LENGTH_SHORT).show()
                newExerciseName = ""
                keyboardController?.hide()
            }
        )
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(space = Context.Gap.default)
        ) {
            items(exercises) { exercise ->
                Exercise(
                    exercise = exercise,
                    deleteOnClick = {}
                )
            }
        }
    }
}