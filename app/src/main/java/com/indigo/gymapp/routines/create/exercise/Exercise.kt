package com.indigo.gymapp.routines.create.exercise

import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.time.Rest

sealed interface Exercise {
    val exerciseName : String
}

data class SetExercise(override val exerciseName: String, val amountOfSets: Int, val rest: Rest) :
    Exercise

data class TimedExercise(override val exerciseName: String, val duration: Duration) : Exercise