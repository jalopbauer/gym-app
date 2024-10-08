package com.indigo.gymapp.routines.exercises.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.SetExercise
import com.indigo.gymapp.domain.routines.exercises.TimedExercise
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun RoutineExerciseDescription(routineExercise: RoutineExercise) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.space)
    ) {
        Title(title = routineExercise.exercise.name, textSize = Medium)
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
        ) {
            when (routineExercise) {
                is SetExercise -> SetExerciseIconTextValue(routineExercise)
                is TimedExercise -> TimedExerciseIconTextValue(routineExercise)
            }
        }
    }
}