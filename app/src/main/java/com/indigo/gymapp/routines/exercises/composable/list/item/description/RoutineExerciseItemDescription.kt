package com.indigo.gymapp.routines.exercises.composable.list.item.description

import androidx.compose.runtime.Composable
import com.indigo.gymapp.routines.exercises.RoutineExercise
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.routines.exercises.TimedExercise

@Composable
fun RoutineExerciseDescription(routineExercise: RoutineExercise) {
    when (routineExercise) {
        is SetExercise -> SetExerciseItemDescription(routineExercise)
        is TimedExercise -> TimedExerciseItemDescription(routineExercise)
    }
}