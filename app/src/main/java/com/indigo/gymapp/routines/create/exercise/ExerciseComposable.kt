package com.indigo.gymapp.routines.create.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.spacing.Spacing
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun Exercise(
    exercise: Exercise
) {
    val selected = false
    val onClick = { TODO() }
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected,
                onClick = onClick
            )
            ExerciseDescription(exercise)
        }
        Icon(
            imageVector = Icons.Outlined.Menu,
            contentDescription = "Sort item",
            tint = Color.Context.Icon.primary
        )
    }

}

@Composable
private fun ExerciseDescription(exercise: Exercise) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.space)
    ) {
        Title(title = exercise.exerciseName, textSize = Medium)
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
        ) {
            when (exercise) {
                is SetExercise -> SetExerciseIconTextValue(exercise)
                is TimedExercise -> TimedExerciseIconTextValue(exercise)
            }
        }
    }
}