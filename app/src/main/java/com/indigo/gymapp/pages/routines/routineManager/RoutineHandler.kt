package com.indigo.gymapp.pages.routines.routineManager

import androidx.annotation.IntRange
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.RoutineExerciseBuilder

interface RoutineHandler {

    fun setRestTimeBetweenExercisesSeconds(@IntRange(from = 0, to = 59) seconds: Int)

    fun setRestTimeBetweenExercisesMinutes(@IntRange(from = 0, to = 59) minutes: Int)

    fun changeRoutineName(newRoutineName: String)

    suspend fun addExercise(routineExercise: RoutineExercise)

    fun setRoutineExerciseBuilder(routineExerciseBuilder: RoutineExerciseBuilder)

    fun setRoutineExerciseBuilderRestMinutes(@IntRange(from = 0, to = 59) minutes: Int)

    fun setRoutineExerciseBuilderRestSeconds(@IntRange(from = 0, to = 59) seconds: Int)
}