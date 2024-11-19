package com.indigo.gymapp.domain.routines.exercises

import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.entity.ExerciseEntity

data class RoutineExerciseBuilder(val rest: Rest, val amountOfSets: Int, val exercise: ExerciseEntity? = null)
