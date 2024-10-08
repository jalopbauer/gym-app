package com.indigo.gymapp.domain.routines.exercises

import com.indigo.gymapp.domain.time.Duration
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.Exercise

sealed interface RoutineExercise {
    val exercise : Exercise
}

data class SetExercise(override val exercise: Exercise, val amountOfSets: Int, val rest: Rest) :
    RoutineExercise

data class TimedExercise(override val exercise: Exercise, val duration: Duration) :
    RoutineExercise