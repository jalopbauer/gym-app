package com.indigo.gymapp.routines.manager

import com.indigo.gymapp.routines.exercises.SetExerciseEntity

sealed interface RoutineExerciseState

data object CreateRoutineExercise : RoutineExerciseState

data class EditRoutineExercise(val id : SetExerciseEntity) : RoutineExerciseState