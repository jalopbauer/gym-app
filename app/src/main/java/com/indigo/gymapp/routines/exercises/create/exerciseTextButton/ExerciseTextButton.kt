package com.indigo.gymapp.routines.exercises.create.exerciseTextButton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.exercises.ExerciseEntity

@Composable
fun ExerciseTextButton(
    exercise: ExerciseEntity,
    getExerciseOnClick: (ExerciseEntity) -> Unit
) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .clickable {
                getExerciseOnClick(exercise)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Headline(exercise.name)
    }
}