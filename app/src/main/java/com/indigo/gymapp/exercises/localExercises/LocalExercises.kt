package com.indigo.gymapp.exercises.localExercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun LocalExercises() {
    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()
    val exercises by exerciseViewModel.exercises.collectAsState(initial = emptyList())
    var newExerciseName by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        Column {
            TextField(
                value = newExerciseName,
                label = stringResource(R.string.exercise_name),
                onValueChange = { newExerciseName = it }
            )
            Button(
                text = stringResource(R.string.add_exercise),
                onClick = { exerciseViewModel.createExercise(newExerciseName) }
            )
        }
        exercises.forEach { exercise ->
            Headline(exercise.name)
        }
    }
}