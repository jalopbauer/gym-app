package com.indigo.gymapp.pages.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun Exercises() {
    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()
    val exercises by exerciseViewModel.exercises.collectAsState(initial = emptyList())
    var newExerciseName by remember {
        mutableStateOf("")
    }

    Column (
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        Column {
            TextField(
                value = newExerciseName,
                label = "ExerciseName",
                onValueChange = { newExerciseName = it}
            )
            Button(
                text = "Add exercise",
                onClick = { exerciseViewModel.createExercise(newExerciseName) }
            )
        }
        exercises.forEach { exercise ->
            Headline(exercise.name)
        }
    }
//    ApiExercises()
}