package com.indigo.gymapp.exercises.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.button.textButton.DeleteTextButton
import com.indigo.gymapp.exercises.entity.ExerciseEntity

@Composable
fun Exercise(
    exercise: ExerciseEntity,
    deleteOnClick: (Long) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DeleteTextButton(
            text = exercise.name,
            onClick = { deleteOnClick(exercise.id) }
        )
    }
}