package com.indigo.gymapp.pages.routines.create.exercise

import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.time.Rest

sealed interface RoutineExercise {
    val exerciseName : String
}

data class SetExercise(override val exerciseName: String, val amountOfSets: Int, val rest: Rest) :
    RoutineExercise

data class TimedExercise(override val exerciseName: String, val duration: Duration) :
    RoutineExercise