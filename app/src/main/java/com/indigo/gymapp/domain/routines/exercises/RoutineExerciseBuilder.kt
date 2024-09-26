package com.indigo.gymapp.domain.routines.exercises

import com.indigo.gymapp.domain.exercises.Exercise
import com.indigo.gymapp.domain.time.Rest

data class RoutineExerciseBuilder(val rest: Rest, val exercise: Exercise? = null)
