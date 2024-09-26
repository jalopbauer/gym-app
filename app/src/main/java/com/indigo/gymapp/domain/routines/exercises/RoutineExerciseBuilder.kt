package com.indigo.gymapp.domain.routines.exercises

import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.pages.exercises.Exercise

data class RoutineExerciseBuilder(val rest: Rest, val exercise: Exercise? = null)
