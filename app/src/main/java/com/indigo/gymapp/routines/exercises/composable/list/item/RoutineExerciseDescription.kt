package com.indigo.gymapp.routines.exercises.composable.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.routines.exercises.RoutineExercise
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.routines.exercises.TimedExercise
import com.indigo.gymapp.ui.number.Number

@Composable
fun RoutineExerciseDescription(routineExercise: RoutineExercise) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Number.Context.Gap.space)
    ) {
        Title(title = routineExercise.exercise.name, textSize = Medium)
        Column(
            verticalArrangement = Arrangement.spacedBy(Number.Context.Gap.default),
        ) {
            when (routineExercise) {
                is SetExercise -> SetExerciseIconTextValue(routineExercise)
                is TimedExercise -> TimedExerciseIconTextValue(routineExercise)
            }
        }
    }
}