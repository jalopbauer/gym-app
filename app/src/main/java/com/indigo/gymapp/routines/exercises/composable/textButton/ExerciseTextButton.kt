package com.indigo.gymapp.routines.exercises.composable.textButton

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.button.textButton.OnlyTextButton
import com.indigo.gymapp.exercises.entity.ExerciseEntity

@Composable
fun ExerciseTextButton(
    exercise: ExerciseEntity,
    getExerciseOnClick: (ExerciseEntity) -> Unit
) {
    OnlyTextButton(
        text = exercise.name,
        onClick = {
            getExerciseOnClick(exercise)
        }
    )
}